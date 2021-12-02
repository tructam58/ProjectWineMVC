package WebBanRuou.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import WebBanRuou.Dto.CartDto;
import WebBanRuou.Entity.Bills;

@Service
public interface IBillsService {
	public int AddBills(Bills bill);
	
	public void AddBillsDetail(HashMap<Long, CartDto> carts);
}
