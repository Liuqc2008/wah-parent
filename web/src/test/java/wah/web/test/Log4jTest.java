package wah.web.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

public class Log4jTest {

	//@Ignore
	@Test
	public void LogTest() {
		 Logger logger = Logger.getLogger(Log4jTest.class);        
        //ʹ��Ĭ�ϵ�������Ϣ������Ҫдlog4j.properties
       // BasicConfigurator.configure();
        //������־�������Ϊinfo���⽫���������ļ������õļ���
        logger.setLevel(Level.INFO);
        //�������Ϣ�������
        logger.info("this is an info");
        logger.warn("this is a warn");
        logger.error("this is an error");
        logger.fatal("this is a fatal");
	}
}
