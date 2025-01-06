package com.ua.service;

import java.util.List;

import com.ua.entity.OrderStatus;

public interface OrderStatusService {
	void saveOrderStatus(OrderStatus orderStatus);
	void updateOrderStatus(OrderStatus orderStatus);
	OrderStatus getOrderStatusById(Long id);
	void deleteById(Long id);
	List<OrderStatus> findAll();
}
