package WebBanRuou.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCountries implements RowMapper<Countries> {

	@Override
	public Countries mapRow(ResultSet rs, int rowNum) throws SQLException {
		Countries country = new Countries();
		country.setCountry_id(rs.getString("country_id"));
		country.setCountry_name(rs.getString("country_name"));
		return country;
	}

}
