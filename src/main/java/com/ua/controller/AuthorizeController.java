package com.ua.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ua.dto.RegisterDto;
import com.ua.entity.User;
import com.ua.entity.enums.Sex;
import com.ua.mapper.UserMapper;
import com.ua.service.UserService;

@Controller
public class AuthorizeController {

	@Autowired
	UserService userService;


	@GetMapping({"/auth"})
	public String showRegister(Model model) {
		model.addAttribute("registerModel", new RegisterDto());
		model.addAttribute("sexs",Sex.values());
		return "auth";
	}
	@PostMapping("/auth")
	public String createUser(@ModelAttribute("registerModel") @Valid RegisterDto registerDto,
			BindingResult result) {

		if(result.hasErrors()) {
			return "/auth";
		}

		userService.save(UserMapper.userRegister(registerDto));

		return "redirect:/login";
	}
	
	@GetMapping({"/","/login"})
	public String showLogin(Model model) {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	   if (auth != null){    
	       new SecurityContextLogoutHandler().logout(request, response, auth);
	   }
	   return "redirect:/login";
	}
	@GetMapping("/isAvalible")
	public String tryLogin(Principal principal) {
		User  user = userService.findByEmail(principal.getName());
		if(user == null) return "redirect:/login";
		else return "redirect:/user";
	}
}
