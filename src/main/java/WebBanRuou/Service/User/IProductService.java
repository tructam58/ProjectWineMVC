package WebBanRuou.Service.User;


import org.springframework.stereotype.Service;

import WebBanRuou.Dto.ProductsDto;

@Service
public interface IProductService {
	public ProductsDto getProductById(String id);
}
