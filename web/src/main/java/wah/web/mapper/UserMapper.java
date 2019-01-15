package wah.web.mapper;

import wah.web.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User>{

    public List<Map<String, Object>> getUserPageList(Map<String, Object> map);
}