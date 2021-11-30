package WebBanRuou.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{

	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public ModelAndView Index() {
		_mvShare.addObject("categories", _homeService.getDataCategory());
		_mvShare.addObject("products", _homeService.getDataProducts());
		_mvShare.setViewName("user/index");
		
		return _mvShare;
	}


	
}
