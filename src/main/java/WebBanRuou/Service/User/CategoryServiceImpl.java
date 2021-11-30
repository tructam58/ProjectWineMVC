package WebBanRuou.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebBanRuou.Dao.CategoryDao;
import WebBanRuou.Dao.ProductDao;
import WebBanRuou.Dto.ProductsDto;
import WebBanRuou.Entity.Categories;
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productsDao;
	
	public List<ProductsDto> GetAllProductsByID(String id) {
		return productsDao.GetAllProductsByID(id);
	}
	
	public List<ProductsDto> GetDataProducts() {
		return productsDao.getDataProducts();
	}

	
//	  @Override public List<ProductsDto> getDataProducts() { List<ProductsDto>
//	  listProducts = productsDao.getDataProducts(); return listProducts; }
	
	public List<ProductsDto> GetDataProductsPaginate(String id,int start, int totalPage) {
		return productsDao.GetDataProductsPaginate(id,start, totalPage);
	}
	
	public List<ProductsDto> GetDataAllProductsPaginate(int start, int totalPage) {
		return productsDao.GetDataAllProductsPaginate(start, totalPage);
	}

	public List<Categories> getDataCategory() {
		return categoryDao.getDataCategories();
	}

}
