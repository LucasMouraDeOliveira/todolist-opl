package com.iagl.persistence;

import org.springframework.stereotype.Component;

import com.iagl.entities.User;

@Component
public class UserDAO {

	public void update(User user) {
		HibernateUtil.saveOrInsert(user);
	}
	
	public void insert(User user) {
		HibernateUtil.saveOrInsert(user);
	}

	public User getUserById(int id) {
		return (User)HibernateUtil.find(User.class, id);
	}

	/*public User getUserByLoginPassword(String login, String password) {
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		User user = (User)session.createCriteria(User.class)
		    .add(Restrictions.eq("login", login))
		    .add(Restrictions.eq("password", password))
		    .uniqueResult();
		session.close();
		return user;
	}*/

}
