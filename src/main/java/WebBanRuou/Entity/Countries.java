package WebBanRuou.Entity;

public class Countries {
	private String country_id;
	private String country_name;
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public Countries(String country_id, String country_name) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
	}
	public Countries() {
		super();
	}
	
}
