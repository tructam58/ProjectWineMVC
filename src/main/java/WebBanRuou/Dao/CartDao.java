package WebBanRuou.Dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import WebBanRuou.Dto.CartDto;
import WebBanRuou.Dto.ProductsDto;

@Repository
public class CartDao extends BaseDao {

	@Autowired
	ProductDao productDao = new ProductDao();

	public HashMap<String, CartDto> addCart(String id, HashMap<String, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto product = productDao.findProductById(id);

		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1 );
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProductsDto().getProduct_price());
		}
		else {
			itemCart.setProductsDto(product);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(product.getProduct_price());
		}
		cart.put(id, itemCart);
		return cart;
	}
	
	public HashMap<String, CartDto> addManyItemCart(String id, int quantity,HashMap<String, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto product = productDao.findProductById(id);

		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			
			itemCart.setQuantity(itemCart.getQuantity() + quantity );
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProductsDto().getProduct_price());
		}
		else {
			itemCart.setProductsDto(product);
			itemCart.setQuantity(quantity);
			itemCart.setTotalPrice(product.getProduct_price());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<String, CartDto> editCart(String id, int quantity, HashMap<String, CartDto> cart) {
		if (cart == null) {
			return cart;
		}

		CartDto itemCart = new CartDto();

		// kiểm tra xem cart có cái id này không
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			double totalPrice = quantity * itemCart.getProductsDto().getProduct_price();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<String, CartDto> deleteCart(String id, HashMap<String, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int totalQuantity(HashMap<String, CartDto> cart) {
		int totalQuantity = 0;
		for(Map.Entry<String, CartDto> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}

	public double totalPrice(HashMap<String, CartDto> cart) {
		double totalPrice = 0;
		for(Map.Entry<String, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
