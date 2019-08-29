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
	public String select(ModelMap m,Integer txt,Integer text,Integer type) {
		String where=" ";
		if(txt!=null&&txt>-1) {
			where=" where book.state="+txt;
			if(text!=null&&text>0) 
				where=where+" and book.id="+text;
			else text=0;
			if(type!=null&&type>-1)
				where=where+" and book.typeid="+type;
			else type=-1;
		}
		else {
			if(text!=null&&text>0) {
				where="where book.id="+text;
				if(type!=null&&type>-1)
					where=where+" and book.typeid="+type;
				else type=-1;
			}
			else {
				if(type!=null&&type>-1)
					where="where book.typeid="+type;
				else type=-1;
				text=0;
			}
			
			txt=-1;
		}
		
		m.put("statesList", bService.select(where));
		m.put("bookList", bService.select(""));
		m.put("typeList", tService.selectAll());
		m.put("states", Book.states);
		m.put("state", txt);
		m.put("bid", text);
		m.put("type", type);
		return "index";
	}
	
	@RequestMapping("delete")
	public String delete(ModelMap m, int id) {
		bService.delete(id);
		return select(m,null,null,null);
	}
	
	@RequestMapping("insert")
	public String insert(ModelMap m, Book b) {
		bService.insert(b);
		return select(m,null,null,null);
	}
	
	@RequestMapping("update")
	public String update(ModelMap m, Book b) {
		bService.update(b);
		return select(m,null,null,null);
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
