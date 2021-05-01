package com.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entities.Todo;
import com.Dao.TodoDao;

@Controller
public class HomeController {
	
	@Autowired
	ServletContext context;
	@Autowired
	TodoDao todoDao;
	
	@RequestMapping("/home")
	public String home(Model m)
	{
		String str="home";
		m.addAttribute("name",str);
		// List<Todo> list=(List<Todo>)context.getAttribute("list");
		
		// get by dao class
		List<Todo> list=this.todoDao.getAll();
		m.addAttribute("todos", list);
		return "home";
	}
	
	@RequestMapping("/add")
	public String add(Model m)
	{
		Todo t=new Todo();
		m.addAttribute("name","add");
		m.addAttribute("todo", t);
		return "home";
	}
	
	
	// save
	@RequestMapping(value="/saveTodo",method=RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo t, Model m)
	{
		System.out.println(t);
		t.setTodoDate(new Date());
		
		//get todo list from context
		// List<Todo> list=(List<Todo>)context.getAttribute("list");        // list will fetch from MyListener class
		// list.add(t);
		
		// save by dao class
		this.todoDao.save(t);
		m.addAttribute("msg","Successfully added");
		
		return "home";
	}
	
	// update view
	@RequestMapping("/update/{todoId}")
	public String update(@PathVariable("todoId") int todoId, Model m)
	{
		Todo todo = this.todoDao.getTodo(todoId);
		m.addAttribute("todo", todo);
		m.addAttribute("msg1","Successfully updated");
		return "update";
		
	}
	
	// delete
	@RequestMapping("/delete/{todoId}")
	public String delete(@PathVariable("todoId") int todoId, Model m)
	{
		this.todoDao.delete(todoId);
		m.addAttribute("msg2", "Successfully deleted");
		return "home";
		
	}
	
	
	

}
