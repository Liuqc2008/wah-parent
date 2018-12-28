package wah.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import wah.web.pojo.Category;
import wah.web.service.CategoryService;

@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	//http://localhost/web/listCategory
	@RequestMapping("listCategory")
	public String listCategory(Model model){
		List<Category> cs= categoryService.list();

		model.addAttribute("cs", cs);
		return "jsp/listCategory";
	}

	@RequestMapping("form")
	public String form(){

		return "jsp/form";
	}
	
	@RequestMapping("layui")
	public String layui(){

		return "jsp/layui";
	}
}
