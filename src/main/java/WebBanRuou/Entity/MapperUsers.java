package WebBanRuou.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users users = new Users();
		users.setUser_id(rs.getLong("user_id"));
		users.setUser_fullname(rs.getString("user_fullname"));
		users.setUser_address(rs.getString("user_address"));
		users.setUser_phone(rs.getString("user_phone"));
		users.setUser_email(rs.getString("user_email"));
		users.setUser_password(rs.getString("user_password"));
		
		return users;
	}

}
