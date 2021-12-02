package WebBanRuou.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebBanRuou.Dao.UsersDao;
import WebBanRuou.Entity.Users;



@Service
public class AccountServiceImpl {
	@Autowired
	UsersDao usersDao = new UsersDao();

	public int AddAccount(Users user) {
		
		user.setUser_password(BCrypt.hashpw(user.getUser_password(), BCrypt.gensalt(12)));
		
		
		return usersDao.AddAccount(user);
	}
	
	
	public Users CheckAccount(Users user) {
		String pass = user.getUser_password();
		
		user = usersDao.GetUserByAcc(user);
		if(user != null) {
			if(BCrypt.checkpw(pass, user.getUser_password())) {
				return user;
			}
			else {
				return null;
			}
			
		}

		return null;
	}
}
