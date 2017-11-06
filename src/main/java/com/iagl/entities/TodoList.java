package com.iagl.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TodoList {
	
	protected Integer id;
	
	protected String name;
	
	protected ArrayList<String> elements;

	@JsonIgnore
	protected User user;
	
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public void getElements() {
		return this.elements;
	}

	public void setElements(ArrayList<String> elements) {
		this.elements = elements;
	}

	public void addElement(String element) {
		this.elements.add(element);
	}

	public void removeElement(String element) {
		this.elements.remove(element);
	}
}
