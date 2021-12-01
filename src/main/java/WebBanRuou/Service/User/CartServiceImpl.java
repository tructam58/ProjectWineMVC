package WebBanRuou.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebBanRuou.Dao.CartDao;
import WebBanRuou.Dto.CartDto;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartDao cartDao = new CartDao();

	@Override
	public HashMap<String, CartDto> addCart(String id, HashMap<String, CartDto> cart) {
		
		return cartDao.addCart(id, cart);
	}
	
	@Override
	public HashMap<String, CartDto> addManyItemCart(String id, int quantity,HashMap<String, CartDto> cart) {
		
		return cartDao.addManyItemCart(id,quantity, cart);
	}
	
	@Override
	public HashMap<String, CartDto> editCart(String id, int quantity, HashMap<String, CartDto> cart) {

		return cartDao.editCart(id, quantity, cart);
	}

	@Override
	public HashMap<String, CartDto> deleteCart(String id, HashMap<String, CartDto> cart) {
	
		return cartDao.deleteCart(id, cart);
	}

	@Override
	public int totalQuantity(HashMap<String, CartDto> cart) {
		
		return cartDao.totalQuantity(cart);
	}

	@Override
	public double totalPrice(HashMap<String, CartDto> cart) {
	
		return cartDao.totalPrice(cart);
	}
}
