package com.ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ua.constants.OrderStatusConst;
import com.ua.service.BookOrderService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	BookOrderService bookOrderService;
	
	@GetMapping("/orders/created")	
	public String showCreatedOrders(Principal principal, Model model) {
		model.addAttribute("created_orders", bookOrderService.findAllByStatusId(OrderStatusConst.CREATED));
		model.addAttribute("created_orders", bookOrderService.findAllByStatusId(OrderStatusConst.CONFIRMED));
		return "admin/orders/created";
	}
	
	@GetMapping("/order/{orderId}")
	public String showOrder(@PathVariable("orderId") long orederId, Principal principal, Model model) {
		return "admin/order";
	}
}
