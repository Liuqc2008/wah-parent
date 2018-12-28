package wah.web.service;

import java.util.List;
import java.util.Map;

import wah.web.pojo.Role;

public interface RoleService {

	List<Role> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	Role getById(int id);

	int add(Role role);

	int update(Role role);

	int delete(Integer id);
}
