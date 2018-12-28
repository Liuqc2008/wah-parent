package wah.web.mapper;

import java.util.List;
import java.util.Map;

import wah.web.pojo.Category;

public interface CategoryMapper {
	public List<Map<String, Object>> GetList();
	
	public List<Category> list();

	public Category get(int id);

	public int add(Category category);

	public int update(Category category);

	public void delete(int id);
}