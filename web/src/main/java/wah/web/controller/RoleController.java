package wah.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import wah.web.pojo.Role;
import wah.web.service.RoleService;

@Controller
@RequestMapping("Role")
public class RoleController {
	@Autowired
	RoleService roleService;

	@RequestMapping(value = "RoleList")
	public String roleList() {

		return "jsp/Role/RoleList";
	}

	@RequestMapping(value = "RoleDetail")
	public String AccountDetail(@RequestParam(defaultValue = "0") int id, Model model) {
		Role role = id == 0 ? new Role() : roleService.getById(id);

		model.addAttribute("role", role);
		return "jsp/Role/RoleDetail";
	}

	@RequestMapping(value = "Add", method = RequestMethod.POST)
	@ResponseBody
	public Object Add(Role model) {
		int result = roleService.add(model);
		return result;
	}

	@RequestMapping(value = "Update", method = RequestMethod.POST)
	@ResponseBody
	public Object Update(Role model) {
		int result = roleService.update(model);
		return result;
	}

	@RequestMapping(value = "Delete", method = RequestMethod.POST)
	@ResponseBody
	public Object Delete(int id) {
		int result = roleService.delete(id);
		return result;
	}
}
