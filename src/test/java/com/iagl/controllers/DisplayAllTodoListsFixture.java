package com.iagl.controllers;

import org.concordion.api.MultiValueResult;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;

import com.iagl.entities.User;
import com.iagl.persistence.TodoListDAO;
import com.iagl.persistence.UserDAO;
import com.iagl.services.PrivateListService;
import com.iagl.services.UserService;

@RunWith(ConcordionRunner.class)
public class DisplayAllTodoListsFixture {
	
protected PrivateListController listController;
	
	protected PrivateListService listService;
	
	protected UserService userService;
	
	protected TodoListDAO todoListDAO;
	
	protected UserDAO userDAO;
	
	@Before
	public void setUp() {
		this.listController = new PrivateListController();
		this.listService = new PrivateListService();
		this.userService = new UserService();
		this.todoListDAO = new TodoListDAO();
		this.userDAO = new UserDAO();
		this.listController.setPrivateListService(this.listService);
		this.listController.setUserService(this.userService);
		this.listService.setTodoListDAO(todoListDAO);
		this.listService.setUserDAO(userDAO);
		this.userService.setUserDAO(userDAO);
	}
	
	public MultiValueResult displayLists() {
		User user = this.userService.createUser("bob");
		int userId = user.getId();
		ResponseEntity<?> response = this.listController.getLists(userId);
		return new MultiValueResult().with("code", response.getStatusCode());
	}
	
	public MultiValueResult displayListsWithInvalidUser() {
		int userId = -1;
		ResponseEntity<?> response = this.listController.getLists(userId);
		return new MultiValueResult().with("code", response.getStatusCode());
	}

}
