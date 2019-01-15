package wah.web.service.impl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import wah.infrastructure.common.PageData;
import wah.web.config.ApplicationContextProvider;
import wah.web.service.CommonService;

@Service("CommonService")
public class CommonServiceImpl implements CommonService {
	
	public Object GetPageData(Map<String, Object> map) throws Exception {
		PageData pageData = new PageData();
		pageData.setData(GetServiceData(map));
		
		map.put("count", true);
		map.remove("page");
		Map<String, Object> listCount =  GetServiceData(map).get(0);
		pageData.setCount(Integer.parseInt(listCount.get("totalNum").toString()));
		
		return pageData;
	}
	
	/*
	 * 代理方式实现动态PageData配置
	 * */	
	public static List<Map<String,Object>> GetServiceData(Map<String, Object> map)  throws Exception{
		String serviceName = CommonServiceImpl.ReportNameConfig().get(map.get("reportName"));

		Class<?> classType= Class.forName("wah.web.service." + serviceName);	//类名
		Method method = classType.getDeclaredMethod(map.get("reportName").toString(), Map.class);	//方法名
		Object bean = ApplicationContextProvider.getBean(serviceName);
		List<Map<String,Object>> result = (List<Map<String, Object>>) method.invoke(bean, map);	//@Service 注册名称
		
		return result;
	}
	
	public static Map<String, String> ReportNameConfig(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("getAccountRolePageList", "AccountService");
		map.put("getAccountPageList", "AccountService");
		map.put("getUserPageList", "UserService");
		map.put("getRolePageList", "RoleService");

		return map;
	}
}
