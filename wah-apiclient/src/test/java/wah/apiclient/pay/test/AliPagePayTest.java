package wah.apiclient.pay.test;

import org.junit.Ignore;
import org.junit.Test;

import wah.apiclient.alipay.page.pay.AliPagePayApi;

public class AliPagePayTest {
	
	@Ignore
	@Test
	public void pagePayTest() throws Exception {
		String result = AliPagePayApi.aliPagePay("20181025175820715", "0.1", "套套20181025175820715", "套套描述");
		
		System.out.println(result);
	}
	
	@Ignore
	@Test
	public void pageQueryTest() throws Exception {
		String result = AliPagePayApi.aliPagePayQuery("20181024175820713", "");
		
		System.out.println(result);
	}
	
	@Ignore
	@Test
	public void aliPageRefundTest() throws Exception {
		AliPagePayApi.aliPageRefund("20181024175820713", "", "0.1", "不想要次物品", "");
		
	}
	
	@Ignore
	@Test
	public void aliPageRefundQuery() throws Exception {
		String result = AliPagePayApi.aliPageRefundQuery("20181024175820713", "", "aliPageRefundQuery");
		
		System.out.println(result);
	}
}
