package wah.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wah.web.mapper.CategoryMapper;
import wah.web.pojo.Category;
import wah.web.service.CategoryService;

@Service("CategoryService")
public class CategoryServiceImpl  implements CategoryService{
	@Autowired
	CategoryMapper categoryMapper;
	
	
	public List<Category> list(){
		return categoryMapper.list();
	}
	
	public List<Map<String, Object>> GetList(){
		return categoryMapper.GetList();
	}
}
