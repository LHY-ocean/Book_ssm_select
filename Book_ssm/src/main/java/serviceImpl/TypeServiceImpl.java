package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TypeDao;
import model.Type;
import service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	TypeDao dao;
	
	public List<Type> selectAll() {
		return dao.selectAll();
	}
	public List<Type> select(String where) {
		return dao.select(where);
	}
	public Type selectById(int id) {
		return dao.selectById(id);
	}
	public void delete(int id) {
		dao.delete(id);
	}
	public void insert(Type t) {
		dao.insert(t);
	}
	public void update(Type t) {
		dao.update(t);
	}
	
}
