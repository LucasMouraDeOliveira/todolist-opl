package com.iagl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iagl.services.PrivateListService;

@RestController
@RequestMapping("/list")
public class PrivateListController {
	
	@Autowired
	protected PrivateListService privateListService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> getLists() {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@RequestMapping(value="/{listName}", method=RequestMethod.GET)
	public ResponseEntity<?> getList(@PathVariable("listName") String listName, @RequestParam("token") int userToken) {
		//Il faudra automatiser ça avec spring
//		this.privateListService.setUserDAO(new UserDAO());
//		User user = this.privateListService.getUserByToken(userToken);
//		if(user != null) {
//			return new ResponseEntity<>(user.getLists(), HttpStatus.OK);
//		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{listName}", method=RequestMethod.POST)
	public ResponseEntity<?> createList(@PathVariable("listName") String listName) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@RequestMapping(value="/{listName}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteList(@PathVariable("listName") String listName) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@RequestMapping(value="/{oldName}/{newName}", method=RequestMethod.PUT)
	public ResponseEntity<?> renameList(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}
