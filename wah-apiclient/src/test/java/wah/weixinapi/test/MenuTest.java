package wah.weixinapi.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import wah.apiclient.sdk.weixin.api.MenuApi;

public class MenuTest {
	
	@Ignore
	@Test
	public void CteateMenuTest() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		
		String result = MenuApi.CreateMenu(param);
		System.out.println(result);
	}
	
	@Ignore
	@Test
	public void DeleteMenuTest() throws Exception {
		String result = MenuApi.DeleteMenu();
		System.out.println(result);
	}
	
	@Ignore
	@Test
	public void GetMenuTest() throws Exception {
		String result = MenuApi.GetMenu();
		
		System.out.println(result);
	}
}
