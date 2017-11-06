package com.iagl.persistence;

import org.springframework.stereotype.Component;

import com.iagl.entities.TodoList;

@Component
public class TodoListDAO {

	public void insert(TodoList todoList) {
		HibernateUtil.saveOrInsert(todoList);
	}

	public void update(TodoList todoList) {
		HibernateUtil.saveOrInsert(todoList);
	}

	public void delete(TodoList todoList) {
		HibernateUtil.delete(todoList);
	}

}
