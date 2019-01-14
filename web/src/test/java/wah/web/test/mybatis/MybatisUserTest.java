package wah.web.test.mybatis;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wah.web.pojo.User;
import wah.web.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class MybatisUserTest {

	@Autowired
	private UserService userService;
	
	@Ignore
	@Test
	public void addList() {
		List<User> userList = new ArrayList<>();
		for(int i =1; i<100; i++) {
			User user = new User();
			user.setName( String.valueOf(i));
			user.setPassword( String.valueOf(i));
			user.setCreateDate(new Date());
			
			userList.add(user);
		}
		
		userService.addList(userList);
	}
	
	@Test
	public void getList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "test");
		List<User> userList = userService.getList(map);
		
		for(User user : userList) {
			System.out.println(user.toString());
		}
	}
	
	@Ignore
	@Test
	public void addTest() {
		User user = new User();
		user.setName( "test");
		user.setPassword( "test");
		user.setCreateDate(new Date());
		
		userService.add(user);
	}
	
	@Ignore
	@Test
	public void getByIdTest() {
		User user = userService.getById(31207);
		
		System.out.println(user.toString());
	}
	
	@Ignore
	@Test
	public void updateTest() {
		User user = userService.getById(31207);
		
		user.setName("testnew");
		int i = userService.update(user);
		System.out.println(i);
	}
	
}
