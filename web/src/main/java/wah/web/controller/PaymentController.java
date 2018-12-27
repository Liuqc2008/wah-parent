package wah.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import wah.web.service.PaymentService;

import wah.infrastructure.web.WebUtil;


@Controller
@RequestMapping("Payment")
public class PaymentController extends BaseController{
	@Autowired
	PaymentService paymentService;
	
	/*
	 * 支付宝网页支付
	 * */
	@RequestMapping(value="AliPagePayIndex")
	public String AliPagePayIndex() throws Exception{

		return "jsp/Payment/AliPagePayIndex";
	}
	
	/*
	 * 跳转支付
	 * */
	@RequestMapping(value="AliPagePay",  method=RequestMethod.POST)
	public String AliPagePay(String out_trade_no, String total_amount, String subject, String body, Model model) throws Exception{
		HashMap<String,String> param =new HashMap<String,String>();
		param.put("out_trade_no", out_trade_no);
		param.put("total_amount", total_amount);
		param.put("subject", subject);
		param.put("body", body);
		
		model.addAttribute("form",  paymentService.aliPagePay(param));  
		return "jsp/Payment/AliPagePay";
	}
	
	/*
	 * 订单查询
	 * */
	@RequestMapping(value="AliPagePayQuery",  method=RequestMethod.POST)
	public String AliPagePayQuery(Model model, HttpServletRequest request) throws Exception{
		Map<String,String> param = WebUtil.GetParameterMap(request.getParameterMap());
		
		model.addAttribute("param1",  paymentService.aliPagePayQuery(param));
		return "jsp/Payment/AliPagePayQuery";
	}
	
	/*
	 * 支付成功回调
	 * */
	@RequestMapping(value="AliPagePayReturn")
	public String AliPageReturn(Model model, HttpServletRequest request) throws Exception{
		Map<String,String> param = WebUtil.GetParameterMap(request.getParameterMap());
		
		model.addAttribute("param",  paymentService.aliPagePayReturn(param));
		return "jsp/Payment/AliPagePayReturn";
	}
	
	/*
	 * 异步通知
	 * */
	@RequestMapping(value="AliPagePayNotify")
	@ResponseBody
	public void AliPagePayNotify(HttpServletRequest request) throws Exception{
		Map<String,String> param = WebUtil.GetParameterMap(request.getParameterMap());
		String result = paymentService.aliPagePayReturn(param);
		
		System.out.println("异步通知：" + result);
	}
	
	/*
	 * 退款
	 * */
	@RequestMapping(value="AliPagePayRefund")
	@ResponseBody
	public void AliPagePayRefund(HttpServletRequest request) throws Exception{
		Map<String,String> param = WebUtil.GetParameterMap(request.getParameterMap());
		
		paymentService.aliPagePayRefund(param);
	}
	
	/*
	 * 退款查询
	 * */
	@RequestMapping(value="AliPagePayRefundQuery")
	public String AliPagePayRefundQuery(HttpServletRequest request, Model model) throws Exception{
		Map<String,String> param = WebUtil.GetParameterMap(request.getParameterMap());
		
		model.addAttribute("param1", paymentService.aliPagePayRefundQuery(param));
		return "jsp/Payment/AliPagePayRefundQuery";
	}
	
	/*
	 * 关闭订单接口
	 * */
	@RequestMapping(value="AliPagePayClose",  method=RequestMethod.POST)
	public String AliPagePayClose(Model model, HttpServletRequest request) throws Exception{
		Map<String,String> param = WebUtil.GetParameterMap(request.getParameterMap());
		
		model.addAttribute("param1",  paymentService.aliPagePayClose(param));
		return "jsp/Payment/AliPagePayClose";
	}
}
