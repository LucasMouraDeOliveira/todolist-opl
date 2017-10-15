package com.iagl.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iagl.entities.TodoList;
import com.iagl.entities.User;
import com.iagl.errors.TodoListAlreadyExistException;
import com.iagl.persistence.TodoListDAO;
import com.iagl.persistence.UserDAO;

@Service
public class PrivateListService {
	
	protected UserDAO userDAO;
	
	protected TodoListDAO todoListDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void setTodoListDAO(TodoListDAO todoListDAO) {
		this.todoListDAO = todoListDAO;
	}

	public void addListToUser(TodoList todoList, User user) throws TodoListAlreadyExistException {
		List<TodoList> lists = user.getLists();
		for(TodoList list : lists) {
			if(list.getName().equals(todoList.getName())) {
				throw new TodoListAlreadyExistException();
			}
		}
		//Si on est arrivé ici c'est qu'il n'y a pas de liste de même nom
		lists.add(todoList);
		this.todoListDAO.insert(todoList);
		this.userDAO.update(user);
	}
	
	public void renameListForUser(User user, TodoList todoList, String newName) throws TodoListAlreadyExistException {
		List<TodoList> lists = user.getLists();
		for(TodoList list : lists) {
			if(!list.equals(todoList) && list.getName().equals(newName)){
				throw new TodoListAlreadyExistException();
			}
		}
		//Si on est arrivé ici c'est qu'il n'y a pas de liste de même nom
		todoList.setName(newName);
		this.todoListDAO.update(todoList);
	}

	public TodoList getListByUserAndName(User user, String listName) {
		for(TodoList todoList : user.getLists()) {
			if(todoList.getName().equals(listName)){
				return todoList;
			}
		}
		return null;
	}

}