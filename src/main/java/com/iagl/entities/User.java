package com.iagl.entities;

import java.util.Set;

public class User {
	
	protected Integer id;
	
	protected String name;
	
	protected Set<TodoList> lists;
	
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

	public Set<TodoList> getLists() {
		return this.lists;
	}
	
	public void setLists(Set<TodoList> lists) {
		this.lists = lists;
	}
	
}
