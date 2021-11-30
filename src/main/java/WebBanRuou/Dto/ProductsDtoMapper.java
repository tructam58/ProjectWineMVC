package WebBanRuou.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsDtoMapper implements RowMapper<ProductsDto> {

	

	@Override
	public ProductsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDto products = new ProductsDto();
		products.setProduct_id(rs.getString("product_id"));
		products.setProduct_name(rs.getString("product_name"));
		products.setProduct_img(rs.getString("product_img"));
		products.setProduct_price(rs.getDouble("product_price"));
		products.setProduct_description(rs.getString("product_description"));
		products.setCreated_at(rs.getDate("created_at"));
		products.setUpdated_at(rs.getDate("updated_at"));
		products.setCategory_id(rs.getString("category_id"));
		products.setCountry_id(rs.getString("country_id"));
		
		return products;
	}
}
