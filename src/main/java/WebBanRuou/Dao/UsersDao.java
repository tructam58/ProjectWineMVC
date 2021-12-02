package WebBanRuou.Dao;

import org.springframework.stereotype.Repository;

import WebBanRuou.Entity.MapperUsers;
import WebBanRuou.Entity.Users;

@Repository
public class UsersDao extends BaseDao {
	public int AddAccount(Users user) {
		StringBuffer  sql = new StringBuffer();
		sql.append("insert ");
		sql.append("into users ( ");
		sql.append("    user_fullname, ");
		sql.append("    user_address, ");
		sql.append("    user_phone, ");
		sql.append("    user_email, ");
		sql.append("    user_password) ");
		sql.append("    values ");
		sql.append("( ");
		sql.append("    	'"+user.getUser_fullname()+"', ");
		sql.append("        '"+user.getUser_address()+"', ");
		sql.append("        '"+user.getUser_phone()+"', ");
		sql.append("        '"+user.getUser_email()+"', ");
		sql.append("        '"+user.getUser_password()+"' ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	};
	
	public Users GetUserByAcc(Users user) {
		
		
		String sql= "select* from users where user_email = '"+user.getUser_email()+"'";
		Users result = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		
		
		return result;
	};
}
