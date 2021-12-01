package WebBanRuou.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import WebBanRuou.Dto.CartDto;
import WebBanRuou.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();

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
	public String addCart(HttpServletRequest request, HttpSession session, @PathVariable String id, @PathVariable int quantity) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.addManyItemCart(id, quantity,cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartService.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "edit-cart/{id}/{quantity}")
	public String editCart(HttpServletRequest request, HttpSession session, @PathVariable String id, @PathVariable int quantity) {
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
}
