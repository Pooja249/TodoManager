package com.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.Entities.Todo;

@Component
public class TodoDao {
	
	@Autowired                      // it will fetch todo-servlet hibernatetemplate automatically
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void save(Todo t)
	{
		this.hibernateTemplate.saveOrUpdate(t);
		
	}
	
	public List<Todo> getAll()
	{
		List<Todo> todos=this.hibernateTemplate.loadAll(Todo.class);
		return todos;
	}

	public Todo getTodo(int todoId) {
		return this.hibernateTemplate.get(Todo.class, todoId);
	}
    
	@Transactional
	public void delete(int todoId) {
		
		Todo t = this.hibernateTemplate.get(Todo.class, todoId);
		this.hibernateTemplate.delete(t);
		
	}

	
}
