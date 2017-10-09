package com.iagl.entities;

import java.util.ArrayList;
import java.util.List;

import com.iagl.errors.TodoListAlreadyExistException;

public class User {
	
	protected List<TodoList> lists;
	
	public User() {
		this.lists = new ArrayList<TodoList>();
	}
	
	public void addList(TodoList list) throws TodoListAlreadyExistException {
		for(TodoList todoList : this.lists) {
			if(todoList.getName().equals(list.getName())) {
				throw new TodoListAlreadyExistException();
			}
		}
		this.lists.add(list);
	}
	
	public List<TodoList> getLists() {
		return this.lists;
	}

}
