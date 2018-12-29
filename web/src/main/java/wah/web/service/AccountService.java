package wah.web.service;

import java.util.List;
import java.util.Map;

import wah.web.pojo.Account;

public interface AccountService {
	
	public List<Map<String, Object>> GetAccountRoleList(Map<String, Object> map);

	public List<Account> list(Map<String, Object> map);

	public int count(Map<String, Object> map);

	public Account get(int id);

	public int add(Account account);

	public int update(Account account);

	public int delete(int id);

	public void transactionAdd();
}
