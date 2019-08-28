package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Type;
import service.TypeService;

@Controller
@RequestMapping("Type")
public class TypeController {
	
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
			where=" where name like '%"+txt+"%'";
		m.put("typeList", tService.select(where));
		return "Type/index";
	}
	
	@RequestMapping("delete")
	public String delete(ModelMap m, int id) {
		tService.delete(id);
		return select(m,null);
	}
	
	@RequestMapping("insert")
	public String insert(ModelMap m, Type t) {
		tService.insert(t);
		return select(m,null);
	}
	
	@RequestMapping("update")
	public String update(ModelMap m, Type t) {
		tService.update(t);
		return select(m,null);
	}
	
	@RequestMapping("add")
	public String add(ModelMap m) {
		return "Type/edit";
	}
	
	@RequestMapping("upd")
	public String upd(ModelMap m, int id) {
		m.put("type", tService.selectById(id));
		return add(m);
	}
	
	
}
