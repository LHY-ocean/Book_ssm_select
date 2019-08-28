package service;

import java.util.List;

import model.Type;

public interface TypeService {
	
	public List<Type> selectAll();
	
	public List<Type> select(String where);
	
	public Type selectById(int id);
	
	public void delete(int id);
	
	public void insert(Type t);
	
	public void update(Type t);
}
