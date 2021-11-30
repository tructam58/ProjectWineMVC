package WebBanRuou.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebBanRuou.Entity.Categories;
import WebBanRuou.Entity.MapperCategories;



@Repository
public class CategoryDao extends BaseDao {
	
	public List<Categories> getDataCategories() {
		List<Categories> list = new ArrayList<Categories>();
		String sql = "select * from categories";
		list = _jdbcTemplate.query(sql, new MapperCategories());
		
		return list;
	}
}
