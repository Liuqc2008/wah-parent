package wah.web.mapper;

import java.util.List;
import java.util.Map;

import wah.web.pojo.Account;

public interface AccountMapper {
	
	public List<Map<String,Object>> GetAccountRoleList(Map<String, Object> map);
	
	public List<Account> list(Map<String, Object> map);

	public int count(Map<String, Object> map);

	public Account get(int id);

	public Account getById(int id);

	public int add(Account account);

	public int update(Account account);

	public int delete(int id);
}