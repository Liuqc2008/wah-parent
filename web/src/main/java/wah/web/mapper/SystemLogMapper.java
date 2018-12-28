package wah.web.mapper;

import wah.web.pojo.SystemLog;

public interface SystemLogMapper {

	int add(SystemLog systemLog);

	int delete(Integer id);
}