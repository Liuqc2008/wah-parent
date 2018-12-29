package wah.web.controller;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import wah.web.service.AccountService;
import wah.web.service.CategoryService;
import wah.web.service.CommonService;
import wah.web.service.RoleService;

import wah.infrastructure.common.PageData;
import wah.infrastructure.extend.MapExtend;

@Controller
@RequestMapping("Common")
public class CommonController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	AccountService accountService;

	@Autowired
	RoleService roleService;
	
	@Autowired
	CommonService commonService;

	@RequestMapping("/CategoryList")
	@ResponseBody
	public Object peopleSelect() {
		return categoryService.GetList();
	}
	
	@RequestMapping("/GetPageData")
	@ResponseBody
	public Object GetPageData(HttpServletRequest request) throws Exception {	
		
		String urlParam = request.getQueryString() == null ? "" : request.getQueryString();
		Map<String, Object> requestParam = MapExtend.StringUrlParamToMap(URLDecoder.decode(urlParam, "UTF-8"));

		return commonService.GetPageData(requestParam);
	}
	
	@RequestMapping(value = "/AccountList", method = RequestMethod.GET)
	@ResponseBody
	public Object AccountList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int limit,
			HttpServletRequest request) throws Exception {
		String urlParam = request.getQueryString() == null ? "" : request.getQueryString();
		PageData pageData = new PageData();

		Map<String, Object> requestParam = MapExtend.StringUrlParamToMap(URLDecoder.decode(urlParam, "UTF-8"));

		pageData.setData(accountService.list(requestParam));
		pageData.setCount(accountService.count(requestParam));
		return pageData;
	}

	@RequestMapping(value = "/RoleList", method = RequestMethod.GET)
	@ResponseBody
	public Object RoleList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int limit,
			HttpServletRequest request) throws Exception {
		String urlParam = request.getQueryString() == null ? "" : request.getQueryString();
		PageData pageData = new PageData();

		Map<String, Object> requestParam = MapExtend.StringUrlParamToMap(URLDecoder.decode(urlParam, "UTF-8"));

		pageData.setData(roleService.list(requestParam));
		pageData.setCount(roleService.count(requestParam));
		return pageData;
	}
}
