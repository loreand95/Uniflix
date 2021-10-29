/*package it.univaq.disim.sose.rest.controller.impl;

import java.util.List;

import it.univaq.disim.sose.rest.controller.TodoRestApi;
import it.univaq.disim.sose.rest.model.Todo;
import it.univaq.disim.sose.rest.model.TodoDAO;

public class TodoRestApiImpl implements TodoRestApi {
	@Override
	public List<Todo> getTodos() {
		return TodoDAO.getTodos();
	}
	
	@Override
	public Todo getTodo(String id) {
		List<Todo> todos = TodoDAO.getTodos();
		if (todos.contains(new Todo(Long.valueOf(id)))) {
			return todos.get(todos.indexOf(new Todo(Long.valueOf(id))));
		}

		return null;
	}
	
	@Override
	public boolean create(Todo todo) {
		List<Todo> todos = TodoDAO.getTodos();
		if (todos.contains(todo)) {
			return false;
		}
		return todos.add(todo);
	}
	
	@Override
	public boolean update(Todo todo) {
		List<Todo> todos = TodoDAO.getTodos();
		if (todos.contains(todo)) {
			todos.remove(todos.indexOf(todo));
		}
		return todos.add(todo);
	}
	@Override
	public boolean delete(String id) {
		List<Todo> todos = TodoDAO.getTodos();
		if (todos.contains(new Todo(Long.valueOf(id)))){
			todos.remove(new Todo(Long.valueOf(id)));
			return true;
		}
		return false;
	}

}
*/