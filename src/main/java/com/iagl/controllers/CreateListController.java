package com.iagl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateListController {
	
	@RequestMapping("/createList")
	public String createList() {
		return "createList";
	}

}
