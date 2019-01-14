package wah.web.mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T>{

	public List<T> getList(Map<String, Object> map);
	
	public T getById(int id);

	public int add(T model);
	
	public void addList(List<T> list);

	public int update(T model);

	public int delete(int id);
	
}
