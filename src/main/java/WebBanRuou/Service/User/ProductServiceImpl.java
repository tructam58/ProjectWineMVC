package WebBanRuou.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebBanRuou.Dao.ProductDao;
import WebBanRuou.Dto.ProductsDto;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	ProductDao productDao = new ProductDao();
	@Override
	public ProductsDto getProductById(String id) {
		List<ProductsDto> listProduct = productDao.getProductById(id); 
		return listProduct.get(0);
	}

}
