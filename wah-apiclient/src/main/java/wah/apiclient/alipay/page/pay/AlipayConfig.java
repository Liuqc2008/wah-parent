package wah.apiclient.alipay.page.pay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091400509473";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDRccjUnCrvbhOWgSVR2egPAssbHvJMj/m811I8/9ddlVyznUAxp/vEBRUMORGdcZuk5MQv/csYyT1wG3NI3OW1CJhCZqFRQtNW6jHjAbaHjGb4TskAYFmdXyHoWCgmRy6n45KmRX8XsZjErSBY0DY5yiZaUvO/sIuJZqDBlZhor3znzQPwgCu0k5alekQjFhm4IqbbKQTgn8fTCzhAY7+njqyP8ZmTt0Re5/GGLGrgl1O3+XYeMJELz+aLS4TEgZnufICcDE5DuukneIpjx1djal4Acvn3fFqK1FqbOOS9hRqQny9dOipgUixGhxMZLuW7VNODvzHpIiChRF77PUDHAgMBAAECggEAVJzPMXVVsxyZNTg/R23s3gOW4gICiQOxNKUYSCRjcR8iMD3a7TSb9XjIJAP6Jcz7wAXbbDfvkLfb5ipwzILRGe269ThY+2cv0fES7k6G2wPRpYbOlSRXj8ga/q5+qdgf9Rtu51U0HvJUcUAvzTFwdrBABkV0y4AbHwsi7pHs3H0ttI7AOTiQU9iH7bjwWKDRy5/0beDOt1bnL7uwGvaLZ/w0NPwQYtzfyfwO7MG51x3/vvhUx1Z4hM34Pr/897URwvzCGO6jpuHE9tyAnl95DWq2BUQGFptdJG0gdFi4LEnbFZxX7lIRPtW+22t3e/5RuWmHorH7wtAkdSVTwXhzwQKBgQDomj2G42+KWP0AdqRAGIP7etZgQiv6rkOlgkyjY/7U5t+SeReIamriMwc8u0Dix5DoO8uWpVSNJiCfuGPWLUMhd1Hznbct5s5Z8K9g5slWPTe5RXr53NIN0j4NoXI9ow4SImCd8Qy7gq9NR3Cbtaoq9zF2Kbl2aYhbCJ0ayXdfmQKBgQDmgzNQksMbiHHYm4I474ZMYFJswO3pW+IB/rjvr7xhY0ivQNAw9rxnXXZqD8vyS52UKdYKe85dIYgqHnAis2F/T4l9vRP9Tq1m8hUDBBalocWK2yC7qPEyOsoAsPmzZIyypre6C7zPqhcT5Qk1/e+7HenhlaVdi6FIO7JHzY9fXwKBgCfFp9uWrA3V5XzczH0BNCAeAuX2qpp0jbCRNRWDFaHF0Fi1R+bVe20uGICz7AZa5VYwU0FxB6IS8OUenEOU/bONOYAUaav5mTMbyoEhNS//y7VsQfjTXz9pwZ6HCoerh85l/mtDOlAdqmfmXUTirTQnjFeODt5GcUBPmr1n0XeRAoGBANo+g/oYSfOqdqdvbJa9aPitBb0D2PzlSpE6+xur1f6awrly8uo44V44JiH6/MxVfUdHaOiaGWMhmUrPcLnZ/khMJM/Qkbl1oUVjlDM7zrlY9bAnEdG6/UniUVjgNjn7zB5lLHRQIp622oyyf8sHts8BXmt/hIaR6cx7AKts2v6fAoGBAKRkt6KIjPiEY+UAnB6yk6RtHln7LR8LSnNOWOL/MU14X5T+zJ4c6aRwaBY6OsXLmjzyk+1WHqRcuNczTXqJ/AdTwRJ88onpIV/ewkgn+9qAPk+xVXdSwtZDlFiKLftwCZvgicYK9sbD4eAhGtRVdBzIA79k2quGonFdrr3qjsOj";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArEa/h0MKWMPaBbFkLT51CiOGPafGmXdf1fP7b+zPRnxX9bwFAviAY/4jWZK4zCVgEAt43KZSGfAgaeOJecz3qAvPemrL5ZAraADXkDbaFC9MRKXTpMNPw95b1ULBgXsr8tyPvkuDLPMY1kC5Ec/oXFUUg2Iw2HcZdM5khJhkOdQQA2xUMgetRqnujHXut8+jhZcEoZrmlAOfURUTaGfymrMy/JzQghr/q49ABkmyqGN7NLPStDNTdRiU6Ix3quY2nnQytktGd5yKZjmZ895iUS0FCtpWxdqJ2qlJqK5S3JerjRHv+ikv6wkYVYBMA0Fb3+M7muMQAPA4UdzPQD6VlQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://313624981.tunnel.qydev.com/MavenSSM/Payment/AliPagePayNotify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://313624981.tunnel.qydev.com/MavenSSM/Payment/AliPagePayReturn";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
