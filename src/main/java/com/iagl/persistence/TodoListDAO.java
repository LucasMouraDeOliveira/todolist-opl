package com.iagl.persistence;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.iagl.entities.TodoList;

@Component
public class TodoListDAO {

	public void insert(TodoList todoList) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
        session.save(todoList);
        session.getTransaction().commit();
        session.close();
	}

	public void update(TodoList todoList) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.update(todoList);
		session.close();
	}

	public void delete(TodoList todoList) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
        session.delete(todoList); 
        session.getTransaction().commit();
		session.close();
	}

}
