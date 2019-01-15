package wah.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wah.web.pojo.User;
import wah.web.service.UserService;

@Controller
@RequestMapping("User")
public class UserController extends BaseController {
	@Autowired
	UserService userService;

	// http://localhost/web/User/UserList
	@RequestMapping(value = "UserList")
	public String UserList() throws Exception {

		return "jsp/User/UserList";
	}

	@RequestMapping(value = "UserDetail")
	public String UserDetail(@RequestParam(defaultValue = "0") int id, Model model) {
		User user = id == 0 ? new User() : userService.getById(id);

		model.addAttribute("user", user);
		return "jsp/User/UserDetail";
	}

	@RequestMapping(value = "Add", method = RequestMethod.POST)
	@ResponseBody
	public Object Add(User model) {
		int result = userService.add(model);
		return result;
	}

	@RequestMapping(value = "Update", method = RequestMethod.POST)
	@ResponseBody
	public Object Update(User model) {
		int result = userService.update(model);
		return result;
	}

	@RequestMapping(value = "Delete", method = RequestMethod.POST)
	@ResponseBody
	public Object Delete(int id) {
		int result = userService.delete(id);
		return result;
	}
}
