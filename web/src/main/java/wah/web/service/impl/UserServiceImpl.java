package wah.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wah.web.mapper.UserMapper;
import wah.web.pojo.User;
import wah.web.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public List<Map<String, Object>> GetUserPageList(Map<String, Object> map){
		return userMapper.GetUserPageList(map);
	}

	@Override
	public List<User> getList(Map<String, Object> map) {
		return userMapper.getList(map);
	}

	@Override
	public User getById(int id) {
		return userMapper.getById(id);
	}

	@Override
	public int add(User user) {
		return userMapper.add(user);
	}

	@Override
	public void addList(List<User> userList) {
		userMapper.addList(userList);
	}

	@Override
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	public int delete(int id) {
		return userMapper.delete(id);
	}

}
