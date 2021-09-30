package com.ua.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ua.dto.OrderStatusDto;
import com.ua.entity.OrderStatus;
import com.ua.mapper.OrderStatusMapper;
import com.ua.service.OrderStatusService;

@Controller
@RequestMapping("/orderstatus")
public class OrderStatusController {

    @Autowired
    OrderStatusService orderStatusService;

    @GetMapping("/all")
    public String showAllOrderStatus(Principal principal, Model model)  {
        List<OrderStatus> orderStatus = orderStatusService.findAll();
        model.addAttribute("orderStatus",orderStatus);
        return"/orderstatus/all";
    }

    @GetMapping ("/create")
    public String createStatus(Principal principal, Model model) {
        model.addAttribute("createOrderStatus", new OrderStatusDto());
        return "/orderstatus/create";
    }

    @PostMapping("/create")
    public String createOrderStatus(Principal principal, @ModelAttribute("createOrderStatus")@Valid OrderStatusDto request, BindingResult result) {
        if(result.hasErrors()) {
            return "/orderstatus/create";
        }
        OrderStatus orderStatus = OrderStatusMapper.dtoToOrderStatus(request);
        orderStatusService.saveOrderStatus(orderStatus);
        return "redirect:/orderstatus/all";
    }


}