package WebBanRuou.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebBanRuou.Dto.ProductsDto;
import WebBanRuou.Dto.ProductsDtoMapper;

@Repository
public class ProductDao extends BaseDao {

	private StringBuffer sqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM products ");
		sql.append(" JOIN categories ON products.category_id = categories.category_id ");
		sql.append(" JOIN countries ON products.country_id = countries.country_id ");
		return sql;
	}
	
	
	
	public List<ProductsDto> getDataProducts() {
		String sql = sqlString().toString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	
	
	
	private String sqlProductsByID(String id) {
		StringBuffer sql = sqlString();
		sql.append(" WHERE products.category_id = '" + id +"' ");

		return sql.toString();
	}
	
	
	
	private String sqlProductsPaginate(String id,int start, int totalPage) {
		StringBuffer sql = sqlString();
		sql.append(" WHERE products.category_id = '" + id +"' ");
		sql.append("LIMIT "+ (start-1) + ", " + totalPage);		
		return sql.toString();
	}
	
	
	
	public List<ProductsDto> GetAllProductsByID(String id) {
		String sql = sqlProductsByID(id);
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	
	
	
	public List<ProductsDto> GetDataProductsPaginate(String id,int start, int totalPage) {
		String sqlGetDataByID = sqlProductsByID(id);
		List<ProductsDto> listProductsByID = _jdbcTemplate.query(sqlGetDataByID, new ProductsDtoMapper());
		List<ProductsDto> listProducts = new ArrayList<ProductsDto>();
		if  (listProductsByID.size()>0) {
			String sql = sqlProductsPaginate(id,start,totalPage);
			listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		}
		
		return listProducts;
	}
	
	
	
	private String sqlAllProductsPaginate(int start, int totalPage) {
		StringBuffer sql = sqlString();
		sql.append("LIMIT "+ (start-1) + ", " + totalPage);		
		return sql.toString();
	}
	
	
	
	public List<ProductsDto> GetDataAllProductsPaginate(int start, int totalPage) {
	    String sql = sqlAllProductsPaginate(start, totalPage);
	    List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper ());
	    return listProducts;
	}
	
	
	
	private String sqlProductByID(String id) {
		StringBuffer sql = sqlString();
		sql.append(" WHERE products.product_id = '" + id +"' ");
		sql.append(" LIMIT 1 ");

		return sql.toString();
	}
	
	
	
	public List<ProductsDto> getProductById(String id) {
		String sql = sqlProductByID(id);
		 List<ProductsDto> listProduct = _jdbcTemplate.query(sql, new ProductsDtoMapper ());
		return listProduct ;
	}
	public ProductsDto findProductById(String id) {
		String sql = sqlProductByID(id);
		ProductsDto product = _jdbcTemplate.queryForObject(sql, new ProductsDtoMapper ());
		return product ;
	}
}
