package com.iagl.entities;

import java.util.Set;

public class User {
	
	protected Integer id;
	
	protected String login;
	
	protected String password;
	
	protected Set<TodoList> lists;
	
	public User() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<TodoList> getLists() {
		return this.lists;
	}
	
	public void setLists(Set<TodoList> lists) {
		this.lists = lists;
	}
	
}
