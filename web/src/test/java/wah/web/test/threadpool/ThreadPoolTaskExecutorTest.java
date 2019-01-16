package wah.web.test.threadpool;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Auther: DHZB
 * @Date: 2019/1/15 16:36
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-*.xml")
public class ThreadPoolTaskExecutorTest {

    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor taskExecutor;

    @Before
    public void init() {
        System.out.println("init");
    }

    @After
    public void destroy(){
        System.err.println("destroy");
    }

    //@Ignore
    @Test
    public void taskExecutorTest(){

        for (int i = 0; i < 10; i++) {
            SpringThread t = new SpringThread(i);
            taskExecutor.execute(t);
        }
        System.out.println("main process is finish .....");
    }
}
