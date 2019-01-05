package wah.web.test.mybatis;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wah.web.mapper.AccountMapper;
import wah.web.pojo.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/applicationContext.xml")
public class CacheTest {
	
	@Resource(name="sqlSession")
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() {
		System.out.println("init");
	}
	
	@After
	public void destroy(){
		System.err.println("destroy");
	}

	@Ignore
	@Test
	public void GetSqlSession() {
		//һ���������
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
		
		System.err.println("------------------��һ�β�ѯ---------------------");
		Account account = accountMapper.get(84);
		System.out.println(account);
		
		System.err.println("------------------�ڶ��β�ѯ---------------------");
		Account account1 = accountMapper.get(84);
		System.out.println(account1);
	}
}
