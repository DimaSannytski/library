package com.ua.controller;

import com.ua.dto.OrderStatusDto;
import com.ua.entity.OrderStatus;
import com.ua.mapper.OrderStatusMapper;
import com.ua.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/orderstatus")
public class OrderStatusController {

    @Autowired
    OrderStatusService orderStatusService;

    @GetMapping("/all")
    public String showAllUsers(Principal principal, Model model)  {
        List<OrderStatus> orderStatus = orderStatusService.findAll();
        model.addAttribute("orderStatus",orderStatus);
        return"/orderstatus/all";
    }

    @GetMapping ("/create")
    public String createGroup(Principal principal, Model model) {
        model.addAttribute("createOrderStatus", new OrderStatusDto());
        return "/orderstatus/create";
    }

    @PostMapping("/create")
    public String createGroupNew(Principal principal, @ModelAttribute("createOrderStatus")@Valid OrderStatusDto request, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/create";
        }
        OrderStatus orderStatus = OrderStatusMapper.dtoToOrderStatus(request);
        orderStatusService.saveOrderStatus(orderStatus);
        return "redirect:/orderstatus/"+orderStatus.getId();
    }

    @GetMapping("/{orderStatusId}")
    public String showOneGroup(@PathVariable("orderStatusId") long orderStatusId, Principal principal, Model model) {
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(orderStatusId);

        if (orderStatus == null) return "redirect:/orderstatus/all";

        model.addAttribute("orderStatusModel", OrderStatusMapper.orderStatusDto(orderStatus));

        return"/orderstatus/orderstatus";
    }

}
