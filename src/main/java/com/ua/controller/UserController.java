package com.ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ua.entity.User;
import com.ua.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String redirectPage(Principal principal,Model model) {
		User user = userService.findByEmail(principal.getName());
		
		
		return "/user/page";
	}
	

}
