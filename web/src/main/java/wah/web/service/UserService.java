package wah.web.service;

import java.util.List;
import java.util.Map;

import wah.web.pojo.User;

public interface UserService {

	public List<Map<String, Object>> GetUserPageList(Map<String, Object> map);

	public List<User> getList(Map<String, Object> map);

	public User getById(int id);

	public int add(User user);
	
	public void addList(List<User> userList);

	public int update(User user);

	public int delete(int id);
}
