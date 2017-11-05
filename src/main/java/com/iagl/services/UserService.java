package com.iagl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iagl.entities.User;
import com.iagl.persistence.UserDAO;

@Service
public class UserService {
	
	@Autowired
	protected UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User createUser(String userName, String password) {
		User user = new User();
		user.setLogin(userName);
		user.setPassword(password);
		this.userDAO.insert(user);
		return user;
	}

	public User getUserById(int userId) {
		User user = this.userDAO.getUserById(userId);
		return user;
	}

	public User findUserByLoginPassword(String login, String password) {
		return this.userDAO.getUserByLoginPassword(login, password);
	}

}
