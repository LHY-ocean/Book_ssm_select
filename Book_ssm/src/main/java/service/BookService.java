package service;

import java.util.List;


import model.Book;

public interface BookService {
	
	public List<Book> select(String where);
	
	public Book selectById(int id);
	
	public void delete(int id);
	
	public void update(Book b);
	
	public void insert(Book b);
}
