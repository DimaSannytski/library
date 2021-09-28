package com.ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ua.entity.Book;
import com.ua.entity.User;
import com.ua.service.BookOrderService;
import com.ua.service.BookService;
import com.ua.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	BookOrderService bookOrderService;
	
	@Autowired 
	BookService bookService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/book")
	public String createOrder(Principal principal, @RequestParam("id") long id) {
		System.out.println("1");
		Book book = bookService.getBookById(id);
		
		User user = userService.findByEmail(principal.getName());
		
		if (book == null || user == null) return "redirect:/book/" + id;
		
		bookOrderService.createOrder(book, user);
		
		return "redirect:/user/";
	}
	

}
