package WebBanRuou.Dao;

import org.springframework.stereotype.Repository;

import WebBanRuou.Entity.BillDetail;
import WebBanRuou.Entity.Bills;

@Repository
public class BillsDao extends BaseDao {
	public int AddBills(Bills bill) {
		StringBuffer  sql = new StringBuffer();
		sql.append("insert ");
		sql.append("into bills ( ");
		sql.append("    bill_fullname, ");
		sql.append("    bill_address, ");
		sql.append("    bill_email, ");
		sql.append("    bill_phone, ");
		sql.append("    bill_notes, ");
		sql.append("    bill_total, ");
		sql.append("    bill_quanty) ");
		sql.append("    values ");
		sql.append("( ");
		sql.append("    	'"+bill.getBill_fullname()+"', ");
		sql.append("        '"+bill.getBill_address()+"', ");
		sql.append("        '"+bill.getBill_email()+"', ");
		sql.append("        '"+bill.getBill_phone()+"', ");
		sql.append("        '"+bill.getBill_notes()+"', ");
		sql.append("        "+bill.getBill_total()+", ");
		sql.append("        "+bill.getBill_quanty()+" ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	};
	
	public long GetIDLastBills() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(bill_id) from bills;");
		long id= _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	};
	
	public int AddBillsDetail(BillDetail billDetail) {
		StringBuffer  sql = new StringBuffer();
		sql.append("insert ");
		sql.append("into billdetail ( ");
		sql.append("    product_id, ");
		sql.append("    bill_id, ");
		sql.append("    bill_quanty, ");
		sql.append("    bill_total) ");
		sql.append("    values ");
		sql.append("( ");
		sql.append("    	'"+billDetail.getProduct_id()+"', ");
		sql.append("        '"+billDetail.getBill_id()+"', ");
		sql.append("        "+billDetail.getBill_quanty()+", ");
		sql.append("        "+billDetail.getBill_total()+" ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	
	
	
	
}
