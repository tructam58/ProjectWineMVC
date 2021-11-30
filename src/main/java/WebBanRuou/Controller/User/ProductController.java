package WebBanRuou.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import WebBanRuou.Service.User.IProductService;

@Controller
public class ProductController extends BaseController{

	@Autowired
	private IProductService _productService;
	
	@RequestMapping(value = "/{id}" , params={"detail"})
	public ModelAndView showProductDetail(@PathVariable String id) {
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("product", _productService.getProductById(id));
		return _mvShare;
	}
}
