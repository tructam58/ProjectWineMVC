package WebBanRuou.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import WebBanRuou.Dto.ProductsDto;
@Service
public interface ICategoryService {
	public List<ProductsDto> GetAllProductsByID(String id);
	public List<ProductsDto> GetDataProducts();
}
