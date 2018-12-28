package wah.web.controller;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
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
import wah.web.service.RoleService;

import wah.infrastructure.common.PageData;

@Controller
@RequestMapping("Common")
public class CommonController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	AccountService accountService;

	@Autowired
	RoleService roleService;

	@RequestMapping("/CategoryList")
	@ResponseBody
	public Object peopleSelect() {
		return categoryService.GetList();
	}
	
	@RequestMapping("/AccountRoleList")
	@ResponseBody
	public Object AccountRoleList(@RequestParam(defaultValue = "0") int page, 
								  @RequestParam(defaultValue = "0") int limit,
						  		  HttpServletRequest request) throws Exception {
		String urlParam = request.getQueryString() == null ? "" : request.getQueryString();
		PageData pageData = new PageData();

		Map<String, Object> requestParam = urlParamToMap(URLDecoder.decode(urlParam, "UTF-8"));

		pageData.setData(accountService.GetAccountRole(requestParam));
		
		requestParam.put("count", true);
		requestParam.remove("page");
		Map<String, Object> listCount =  accountService.GetAccountRole(requestParam).get(0);
		pageData.setCount(Integer.parseInt(listCount.get("totalNum").toString()));
		
		return pageData;
	}

	@RequestMapping(value = "/AccountList", method = RequestMethod.GET)
	@ResponseBody
	public Object AccountList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int limit,
			HttpServletRequest request) throws Exception {
		String urlParam = request.getQueryString() == null ? "" : request.getQueryString();
		PageData pageData = new PageData();

		Map<String, Object> requestParam = urlParamToMap(URLDecoder.decode(urlParam, "UTF-8"));

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

		Map<String, Object> requestParam = urlParamToMap(URLDecoder.decode(urlParam, "UTF-8"));

		pageData.setData(roleService.list(requestParam));
		pageData.setCount(roleService.count(requestParam));
		return pageData;
	}

	public Map<String, Object> urlParamToMap(String urlParam) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		String[] param = urlParam.split("&");

		for (String keyvalue : param) {
			String[] pair = keyvalue.split("=");

			if (pair.length == 2) {
				if (pair[0].indexOf("key") >= 0)
					pair[0] = pair[0].replace("key[", "").replace("]", "");

				if (pair[0].equals("page") || pair[0].equals("limit"))
					hashMap.put(pair[0], Integer.parseInt(pair[1]));
				else
					hashMap.put(pair[0], pair[1]);
			}
		}

		return hashMap;
	}
}
