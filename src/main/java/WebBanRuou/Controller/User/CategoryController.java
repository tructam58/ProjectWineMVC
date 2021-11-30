package WebBanRuou.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;


import WebBanRuou.Dto.PaginatesDto;
import WebBanRuou.Service.User.CategoryServiceImpl;
import WebBanRuou.Service.User.PaginateServiceImpl;
@Controller
public class CategoryController extends BaseController{

	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private PaginateServiceImpl paginateService;

	private int totalProductsPage = 6;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.setViewName("user/products/category");
		_mvShare.addObject("categories", _homeService.getDataCategory());
		_mvShare.addObject("countries", _homeService.getDataCountry());
		
		int totalData = categoryService.GetAllProductsByID(id).size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(id,paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	

	
	@RequestMapping(value = "/san-pham")
	public ModelAndView Product() {
		_mvShare.setViewName("user/products/category");
		_mvShare.addObject("categories", _homeService.getDataCategory());
		_mvShare.addObject("countries", _homeService.getDataCountry());
		
		int totalData = categoryService.GetDataProducts().size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
//		_mvShare.addObject("idCategory");
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataAllProductsPaginate(paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	
	@RequestMapping(value = "/san-pham/page={currentPage:.*}")
	public ModelAndView Product(@PathVariable int currentPage) {
		_mvShare.setViewName("user/products/category");
		_mvShare.addObject("categories", _homeService.getDataCategory());
		_mvShare.addObject("countries", _homeService.getDataCountry());
		
		int totalData = categoryService.GetDataProducts().size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, currentPage);
//		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataAllProductsPaginate(paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}

	
}
