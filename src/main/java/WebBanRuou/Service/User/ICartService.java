package WebBanRuou.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import WebBanRuou.Dto.CartDto;

@Service
public interface ICartService {

	public HashMap<String, CartDto> addCart(String id, HashMap<String, CartDto> cart);
	public HashMap<String, CartDto> editCart(String id, int quantity, HashMap<String, CartDto> cart);
	public HashMap<String, CartDto> deleteCart(String id, HashMap<String, CartDto> cart);
	public HashMap<String, CartDto> addManyItemCart(String id, int quantity, HashMap<String, CartDto> cart);
	public int totalQuantity(HashMap<String, CartDto>cart);
	public double totalPrice(HashMap<String, CartDto> cart);
}
