package WebBanRuou.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebBanRuou.Dao.CategoryDao;
import WebBanRuou.Dao.CountryDao;
import WebBanRuou.Dao.ProductDao;
import WebBanRuou.Dto.ProductsDto;
import WebBanRuou.Entity.Categories;
import WebBanRuou.Entity.Countries;

@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private ProductDao productDao;
	
	public List<Categories> getDataCategory() {
		return categoryDao.getDataCategories();
	}
	public List<Countries> getDataCountry() {
		return countryDao.getDataCountry();
	}

	@Override
	public List<ProductsDto> getDataProducts() {
		List<ProductsDto> listProducts = productDao.getDataProducts();
		return listProducts;
	}
	
	
}
