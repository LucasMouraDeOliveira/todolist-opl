package com.iagl.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.iagl.entities.User;

@Component
public class UserDAO {

	private SessionFactory sessionFactory;

	public void update(User user) {
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
	}

	public User getUserById(int id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}

	public void insert(User user) {
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
	}

}
