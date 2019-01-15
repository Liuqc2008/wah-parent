package wah.web.controller;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wah.web.service.CommonService;
import wah.infrastructure.extend.MapExtend;

@Controller
@RequestMapping("Common")
public class CommonController {

	@Autowired
	CommonService commonService;
	
	@RequestMapping("/GetPageData")
	@ResponseBody
	public Object GetPageData(HttpServletRequest request) throws Exception {	
		
		String urlParam = request.getQueryString() == null ? "" : request.getQueryString();
		Map<String, Object> requestParam = MapExtend.StringUrlParamToMap(URLDecoder.decode(urlParam, "UTF-8"));

		return commonService.GetPageData(requestParam);
	}
}
