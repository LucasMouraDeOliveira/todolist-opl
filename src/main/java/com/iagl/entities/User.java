package com.iagl.entities;

import java.util.List;

public class User {
	
	protected Integer id;
	
	protected String name;
	
	protected List<TodoList> lists;
	
	public User() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<TodoList> getLists() {
		return this.lists;
	}
	
	public void setLists(List<TodoList> lists) {
		this.lists = lists;
	}
	
}
