package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Book;
import service.BookService;
import service.TypeService;

@Controller
@RequestMapping("Book")
public class BookController {
	
	@Autowired
	BookService bService;
	
	@Autowired
	TypeService tService;
	
	@ExceptionHandler
	public void excep(Exception e) {
		e.printStackTrace();
	}
	
	@RequestMapping("index")
	public String select(ModelMap m,String txt) {
		String where="";
		if(txt!=null&&txt!="")
			where=" where book.name like '%"+txt+"%'";
		m.put("bookList", bService.select(where));
		return "Book/index";
	}
	
	@RequestMapping("delete")
	public String delete(ModelMap m, int id) {
		bService.delete(id);
		return select(m,null);
	}
	
	@RequestMapping("insert")
	public String insert(ModelMap m, Book b) {
		bService.insert(b);
		return select(m,null);
	}
	
	@RequestMapping("update")
	public String update(ModelMap m, Book b) {
		bService.update(b);
		return select(m,null);
	}
	
	@RequestMapping("add")
	public String add(ModelMap m) {
		m.put("states", Book.states);
		m.put("typeList",tService.selectAll());
		return "Book/edit";
	}
	
	@RequestMapping("upd")
	public String upd(ModelMap m, int id) {
		m.put("book", bService.selectById(id));
		return add(m);
	}
	
	
}
