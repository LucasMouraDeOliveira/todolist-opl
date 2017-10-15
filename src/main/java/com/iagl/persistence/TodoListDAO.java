package com.iagl.persistence;

import org.hibernate.Session;

import com.iagl.entities.TodoList;

public class TodoListDAO {

	public void insert(TodoList todoList) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
        session.save(todoList);
        session.getTransaction().commit();
	}

	public void update(TodoList todoList) {
		// TODO Auto-generated method stub
	}

	public TodoList find(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TodoList list = (TodoList) session.get(TodoList.class, id);
		return list;
	}

}
