package wah.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.CacheNamespace;

import org.apache.ibatis.cache.decorators.FifoCache;

import wah.web.pojo.Account;
/*
@CacheNamespace(
			eviction = FifoCache.class,
			flushInterval = 60000,
			size=512,
			readWrite = false
		)*/
public interface AccountMapper {
	
	public List<Map<String,Object>> getAccountRolePageList(Map<String, Object> map);

	public List<Map<String, Object>> getAccountPageList(Map<String, Object> map);
	
	public List<Account> list(Map<String, Object> map);

	public int count(Map<String, Object> map);

	public Account get(int id);

	public Account getById(int id);

	public int add(Account account);

	public int update(Account account);

	public int delete(int id);
}