package WebBanRuou.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import WebBanRuou.Dto.CartDto;
import WebBanRuou.Entity.Bills;
import WebBanRuou.Entity.Users;
import WebBanRuou.Service.User.BillsServiceImpl;
import WebBanRuou.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();

	@Autowired
	private BillsServiceImpl billsService = new BillsServiceImpl();
	@RequestMapping(value = "gio-hang")
	public ModelAndView Index() {
		_mvShare.addObject("categories", _homeService.getDataCategory());
		_mvShare.addObject("products", _homeService.getDataProducts());
		_mvShare.setViewName("user/cart/list_cart");

		return _mvShare;
	}

	@RequestMapping(value = "add-cart/{id}")
	public String addCart(HttpServletRequest request, HttpSession session, @PathVariable String id) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.addCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartService.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "add-many-cart/{id}/{quantity}")
	public String addCart(HttpServletRequest request, HttpSession session, @PathVariable String id,
			@PathVariable int quantity) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.addManyItemCart(id, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartService.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "edit-cart/{id}/{quantity}")
	public String editCart(HttpServletRequest request, HttpSession session, @PathVariable String id,
			@PathVariable int quantity) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}

		cart = cartService.editCart(id, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartService.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "delete-cart/{id}")
	public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable String id) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}

		cart = cartService.deleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartService.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public ModelAndView Checkout(HttpServletRequest request, HttpSession session) {	
		_mvShare.setViewName("user/bills/checkout");
		Bills bills = new Bills();
		Users loginInfo = (Users)session.getAttribute("LoginInfo");
		if(loginInfo != null) {
			bills.setBill_address(loginInfo.getUser_address());
			bills.setBill_fullname(loginInfo.getUser_fullname());
			bills.setBill_email(loginInfo.getUser_email());
			bills.setBill_phone(loginInfo.getUser_phone());
			
		}
		
		_mvShare.addObject("bills", bills);
		return _mvShare;
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String CheckoutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bills") Bills bills) {
		bills.setBill_quanty(( (Integer) session.getAttribute("TotalQuantityCart")));
		bills.setBill_total(( (Double) session.getAttribute("TotalPriceCart")));
		
		
		if(billsService.AddBills(bills) > 0) {
			HashMap<Long, CartDto> carts = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			billsService.AddBillsDetail(carts);
		}
		session.removeAttribute("Cart");
		return "redirect:gio-hang";
	}

}
