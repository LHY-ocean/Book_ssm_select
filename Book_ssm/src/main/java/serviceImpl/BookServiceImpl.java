package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookDao;
import model.Book;
import service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao dao;
	public List<Book> select(String where) {
		return dao.select(where);
	}
	
	public Book selectById(int id) {
		return dao.selectById(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void update(Book b) {
		dao.update(b);
	}

	public void insert(Book b) {
		dao.insert(b);
	}

}
