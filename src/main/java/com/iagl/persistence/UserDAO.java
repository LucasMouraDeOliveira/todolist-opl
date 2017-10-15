package com.iagl.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iagl.entities.User;

public class UserDAO {

	private SessionFactory sessionFactory;

	public void update(User user) {
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.save(user);
	}

	public User getUserByToken(int token) {
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, token);
		return user;
	}

}
