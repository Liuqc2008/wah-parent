package wah.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import wah.web.pojo.Account;
import wah.web.service.AccountService;

@Controller
@RequestMapping("Account")
public class AccountController extends BaseController {
	@Autowired
	AccountService accountService;

	// http://localhost/web/Account/AccountList
	@RequestMapping(value = "AccountList")
	public String AccountList() throws Exception {

		return "jsp/Account/AccountList";
	}

	@RequestMapping(value = "AccountDetail")
	public String AccountDetail(@RequestParam(defaultValue = "0") int id, Model model) {
		Account account = id == 0 ? new Account() : accountService.get(id);

		model.addAttribute("account", account);
		return "jsp/Account/AccountDetail";
	}

	@RequestMapping(value = "Add", method = RequestMethod.POST)
	@ResponseBody
	public Object Add(Account model) {
		int result = accountService.add(model);
		return result;
	}

	@RequestMapping(value = "Update", method = RequestMethod.POST)
	@ResponseBody
	public Object Update(Account model) {
		int result = accountService.update(model);
		return result;
	}

	@RequestMapping(value = "Delete", method = RequestMethod.POST)
	@ResponseBody
	public Object Delete(int id) {
		int result = accountService.delete(id);
		return result;
	}
}
