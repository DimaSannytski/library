package com.ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizeController {

	@GetMapping({"/auth", "/", "/libr"})
	public String authPage() {
		return "auth";
	}

}
