package wah.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wah.web.mapper.CommonMapper;
import wah.web.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	CommonMapper commonMapper;

	public Object executeSql(String value) {

		return commonMapper.executeSql(value);
	}

}
