package WebBanRuou.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebBanRuou.Entity.Countries;
import WebBanRuou.Entity.MapperCountries;

@Repository
public class CountryDao extends BaseDao{
	
	public List<Countries> getDataCountry() {
		List<Countries> list = new ArrayList<Countries>();
		String sql = "select * from countries";
		list = _jdbcTemplate.query(sql, new MapperCountries());
		return list;
	}
}
