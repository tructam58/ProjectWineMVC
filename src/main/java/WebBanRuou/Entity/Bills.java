package WebBanRuou.Entity;

public class Bills {
	private long bill_id;
	private String bill_fullname;
	private String bill_address;
	private String bill_email;
	private String bill_phone;
	private String bill_notes;
	private double bill_total;
	private int bill_quanty;
		
	public Bills() {
		super();
	}
	public long getBill_id() {
		return bill_id;
	}
	public void setBill_id(long bill_id) {
		this.bill_id = bill_id;
	}
	public String getBill_fullname() {
		return bill_fullname;
	}
	public void setBill_fullname(String bill_fullname) {
		this.bill_fullname = bill_fullname;
	}
	public String getBill_address() {
		return bill_address;
	}
	public void setBill_address(String bill_address) {
		this.bill_address = bill_address;
	}
	public String getBill_email() {
		return bill_email;
	}
	public void setBill_email(String bill_email) {
		this.bill_email = bill_email;
	}
	public String getBill_phone() {
		return bill_phone;
	}
	public void setBill_phone(String bill_phone) {
		this.bill_phone = bill_phone;
	}
	public String getBill_notes() {
		return bill_notes;
	}
	public void setBill_notes(String bill_notes) {
		this.bill_notes = bill_notes;
	}
	public double getBill_total() {
		return bill_total;
	}
	public void setBill_total(double bill_total) {
		this.bill_total = bill_total;
	}
	public int getBill_quanty() {
		return bill_quanty;
	}
	public void setBill_quanty(int bill_quanty) {
		this.bill_quanty = bill_quanty;
	}
	
	
}
