package wah.web.mapper;

import java.util.List;
import java.util.Map;

import wah.web.pojo.Role;

public interface RoleMapper {

	public List<Map<String, Object>> getRolePageList(Map<String, Object> map);

	List<Role> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	Role getById(int id);

	int add(Role role);

	int update(Role role);

	int delete(Integer id);
}