package com.iagl.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	/*@Autowired
	private UserService userService;*/
	
	/*@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> connect(@RequestParam("login") String login, @RequestParam("password") String password) {
		User user = this.userService.findUserByLoginPassword(login, password);
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}*/

}
