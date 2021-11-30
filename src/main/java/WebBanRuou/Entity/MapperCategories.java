package WebBanRuou.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCategories implements RowMapper<Categories> {

	@Override
	public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categories categories = new Categories();
		categories.setCategory_id(rs.getString("category_id"));
		categories.setCategory_name(rs.getString("category_name"));
		categories.setCategory_img(rs.getString("category_img"));
		categories.setCategory_description(rs.getString("category_description"));
		return categories;
	}

}
