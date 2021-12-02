package WebBanRuou.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebBanRuou.Dao.BillsDao;
import WebBanRuou.Dto.CartDto;
import WebBanRuou.Entity.BillDetail;
import WebBanRuou.Entity.Bills;

@Service
public class BillsServiceImpl implements IBillsService {

	@Autowired
	private BillsDao billsDao;
	
	
	public int AddBills(Bills bills) {
		
		return billsDao.AddBills(bills);
	}


	public void AddBillsDetail(HashMap<Long, CartDto> carts) {
		long idBills = billsDao.GetIDLastBills();
		for(Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setBill_id(idBills);
			billDetail.setProduct_id(itemCart.getValue().getProductsDto().getProduct_id());
			billDetail.setBill_quanty(itemCart.getValue().getQuantity());
			billDetail.setBill_total(itemCart.getValue().getTotalPrice());
			billsDao.AddBillsDetail(billDetail);
		}

	}

}
