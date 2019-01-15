package wah.web.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wah.web.pojo.Account;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-*.xml")
public class MyBatisTest {

    @Resource(name = "sqlSession")
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() {
        System.out.println("init");
    }

    @After
    public void destroy() {
        System.err.println("destroy");
    }

    /**
     * 通过sqlserssion直接执行xml
     */
    //@Ignore
    @Test
    public void selectTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Account account = sqlSession.selectOne("wah.web.mapper.AccountMapper.get",84);
        System.out.println(account);
    }


}
