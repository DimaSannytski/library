package com.ua.dao;

import java.util.List;

import com.ua.entity.OrderStatus;

public interface OrderStatusDao {

	void saveOrderStatus(OrderStatus orderStatus);
	void updateOrderStatus(OrderStatus orderStatus);
	OrderStatus getOrderStatusById(Long id);
	void deleteById(Long id);
	List<OrderStatus> findAll();
	
	//OrderStatus getOrderStatusByEnum(OrderStatusEnum orderStatusEnum);
}
