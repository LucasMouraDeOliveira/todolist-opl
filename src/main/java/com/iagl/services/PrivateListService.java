package com.iagl.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iagl.entities.TodoList;
import com.iagl.entities.User;
import com.iagl.errors.TodoListAlreadyExistException;
import com.iagl.persistence.TodoListDAO;
import com.iagl.persistence.UserDAO;

@Service
public class PrivateListService {
	
	@Autowired
	protected UserDAO userDAO;
	
	@Autowired
	protected TodoListDAO todoListDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void setTodoListDAO(TodoListDAO todoListDAO) {
		this.todoListDAO = todoListDAO;
	}

	public void addListToUser(TodoList todoList, User user) throws TodoListAlreadyExistException {
		Set<TodoList> lists = user.getLists();
		for(TodoList list : lists) {
			if(list.getName().equals(todoList.getName())) {
				throw new TodoListAlreadyExistException();
			}
		}
		//Si on est arrivé ici c'est qu'il n'y a pas de liste de même nom
		lists.add(todoList);
		todoList.setUser(user);
		this.todoListDAO.insert(todoList);
		this.userDAO.update(user);
	}
	
	public void renameListForUser(User user, TodoList todoList, String newName) throws TodoListAlreadyExistException {
		Set<TodoList> lists = user.getLists();
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

	public void deleteTodoListFromUser(String listName, User user) {
		TodoList todoList = getListByUserAndName(user, listName);
		this.todoListDAO.delete(todoList);
		user.getLists().remove(todoList);
		this.userDAO.update(user);
	}

}