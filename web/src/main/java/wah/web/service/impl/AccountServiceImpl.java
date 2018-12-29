package wah.web.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import wah.web.mapper.AccountMapper;
import wah.web.pojo.Account;
import wah.web.service.AccountService;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountMapper accountMapper;

	public List<Map<String, Object>> GetAccountRoleList(Map<String, Object> map){
		return accountMapper.GetAccountRoleList(map);
	}
	
	public List<Account> list(Map<String, Object> map) {
		return accountMapper.list(map);
	}

	public int count(Map<String, Object> map) {
		return accountMapper.count(map);
	}

	public Account get(int id) {
		return accountMapper.get(id);
	}

	public int add(Account account) {

		account.setCreateDate(new Date());
		return accountMapper.add(account);
	}

	public int update(Account account) {
		return accountMapper.update(account);
	}

	public int delete(int id) {
		return accountMapper.delete(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public void transactionAdd() {
		Account a1 = new Account();
		a1.setName("Transaction");
		a1.setPassword("");
		a1.setCreateDate(new Date());
		accountMapper.add(a1);

		Account a2 = new Account();
		a2.setName(
				"TransactiTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionTransactionon");
		a2.setPassword("");
		a2.setCreateDate(new Date());
		accountMapper.add(a2);

	}
}
