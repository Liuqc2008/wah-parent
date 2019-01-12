package wah.web.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wah.web.util.RedisUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class RedisTest {

	// @Resource
	// private RedisTemplate<Serializable,Serializable> redisTemplate;

	// @Ignore
	@Test
	public void testlink() {
		// =====================testString======================
		RedisUtil.set("name", "how2java");
		System.out.println(RedisUtil.get("name"));
		RedisUtil.del("name");
		System.out.println(RedisUtil.get("name"));

		// =====================testNumber======================
		long incr = RedisUtil.incr("number", 1);
		System.out.println(incr);
		incr = RedisUtil.incr("number", 1);
		System.out.println(incr);

		// =====================testMap======================
		Map<String, Object> map = new HashMap<>();
		map.put("name", "meepo");
		map.put("pwd", "password");
		RedisUtil.hmset("user", map);
		System.out.println(RedisUtil.hget("user", "name"));
	}
}
