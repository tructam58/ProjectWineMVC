package WebBanRuou.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebBanRuou.Dto.ProductsDto;
import WebBanRuou.Entity.Categories;
import WebBanRuou.Entity.Countries;

@Service
public interface IHomeService {
 
	@Autowired
	public List<Categories> getDataCategory();
	public List<Countries> getDataCountry();
	public List<ProductsDto> getDataProducts();
}
