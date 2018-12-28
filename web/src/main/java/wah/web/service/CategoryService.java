package wah.web.service;

import java.util.List;
import java.util.Map;

import wah.web.pojo.Category;

public interface CategoryService {

	List<Category> list();
	
	public List<Map<String, Object>> GetList();
}
