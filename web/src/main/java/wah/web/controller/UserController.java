package wah.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;
import wah.web.pojo.User;
import wah.web.service.UserService;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("User")
public class UserController extends BaseController {
	@Autowired
	UserService userService;

	@Resource(name = "taskExecutor")
	private ThreadPoolTaskExecutor taskExecutor;

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

	int result = 0;
	@RequestMapping(value = "Add", method = RequestMethod.POST)
	@ResponseBody
	public Object Add(User model) {
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					System.out.println("当前线程Id：" + Thread.currentThread().getId());
					result = userService.add(model);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

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
