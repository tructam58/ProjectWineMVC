package WebBanRuou.Entity;

public class BillDetail {
	private long id;
	private String product_id;
	private long bill_id;
	private int bill_quanty;
	private double bill_total;
	public BillDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public long getBill_id() {
		return bill_id;
	}
	public void setBill_id(long bill_id) {
		this.bill_id = bill_id;
	}
	public int getBill_quanty() {
		return bill_quanty;
	}
	public void setBill_quanty(int bill_quanty) {
		this.bill_quanty = bill_quanty;
	}
	public double getBill_total() {
		return bill_total;
	}
	public void setBill_total(double bill_total) {
		this.bill_total = bill_total;
	}
	
	
}
