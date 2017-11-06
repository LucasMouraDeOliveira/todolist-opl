package com.iagl.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iagl.entities.TodoList;
import com.iagl.entities.User;
import com.iagl.errors.TodoListAlreadyExistException;
import com.iagl.services.PrivateListService;
import com.iagl.services.UserService;

@RestController
@RequestMapping("/list")
public class PrivateListController {
	
	@Autowired
	protected PrivateListService privateListService;
	
	@Autowired
	protected UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> getLists(@RequestParam("token") int userId) {
		User user = this.userService.getUserById(userId);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Set<TodoList> lists = user.getLists();
		return new ResponseEntity<>(lists, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{listName}", method=RequestMethod.GET)
	public ResponseEntity<?> getList(@PathVariable("listName") String listName, @RequestParam("token") int userId) {
//		User user = this.privateListService.getUserByToken(userToken);
//		if(user != null) {
//			return new ResponseEntity<>(user.getLists(), HttpStatus.OK);
//		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{listName}", method=RequestMethod.POST)
	public ResponseEntity<?> createList(@PathVariable("listName") String listName, @RequestParam("id") int userId) {
		User user = this.userService.getUserById(userId);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		TodoList todoList = new TodoList();
		todoList.setName(listName);
		try {
			this.privateListService.addListToUser(todoList, user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (TodoListAlreadyExistException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{listName}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteList(@PathVariable("listName") String listName, @RequestParam("id") int userId) {
		System.out.println("deleting requested");
		User user = this.userService.getUserById(userId);
		System.out.println("User = " + user);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		this.privateListService.deleteTodoListFromUser(listName, user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{oldName}/{newName}", method=RequestMethod.PUT)
	public ResponseEntity<?> renameList(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	//Pour les tests uniquement vu que je ne vois pas comment injecter les beans
	@Deprecated
	public void setPrivateListService(PrivateListService listService) {
		this.privateListService = listService;
	}
	
	@Deprecated
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
