package com.iagl.services;

import java.util.List;

import com.iagl.entities.TodoList;
import com.iagl.entities.User;
import com.iagl.errors.TodoListAlreadyExistException;
import com.iagl.persistence.TodoListDAO;
import com.iagl.persistence.UserDAO;

public class PrivateListService {
	
	protected UserDAO userDAO;
	
	protected TodoListDAO todoListDAO;

	public void addListToUser(TodoList todoList, User user) throws TodoListAlreadyExistException {
		List<TodoList> lists = user.getLists();
		for(TodoList list : lists) {
			if(list.getName().equals(todoList.getName())) {
				throw new TodoListAlreadyExistException();
			}
		}
		//Si on est arrivé ici c'est qu'il n'y a pas de liste de même nom
		user.addList(todoList);
		this.todoListDAO.insert(todoList);
		this.userDAO.update(user);
		
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void setTodoListDAO(TodoListDAO todoListDAO) {
		this.todoListDAO = todoListDAO;
	}

}
