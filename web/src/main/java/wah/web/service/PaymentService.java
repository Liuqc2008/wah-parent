package wah.web.service;

import java.util.Map;

public interface PaymentService {
	public String aliPagePay(Map<String, String> param) throws Exception;

	public String aliPagePayQuery(Map<String, String> param) throws Exception;

	public String aliPagePayReturn(Map<String, String> param) throws Exception;

	public void aliPagePayRefund(Map<String, String> param) throws Exception;

	public String aliPagePayRefundQuery(Map<String, String> param) throws Exception;

	public String aliPagePayClose(Map<String, String> param) throws Exception;
}
