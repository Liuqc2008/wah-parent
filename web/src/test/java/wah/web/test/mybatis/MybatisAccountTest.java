package wah.web.test.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wah.web.mapper.AccountMapper;
import wah.web.pojo.Account;
import wah.web.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class MybatisAccountTest {
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	
	private AccountService accountService;
	@Ignore
	@Test
	public void testAccountList() {
		Map<String, Object> map = new HashMap<String, Object>();
	
		List<Account> accountList=accountMapper.list(map);
		
		for (Account account : accountList) {
			System.out.println(account);
		}
	}
	
	@Ignore
	@Test
	public void testGetById() {
		Account account = accountMapper.get(84);
		System.out.println(account);
	}
	
	@Ignore
	@Test
	public void testTransaction() {
		accountService.transactionAdd();
		
	}
}
