package com.ua.service;

import java.util.List;

import com.ua.entity.OrderStatus;
import com.ua.entity.enums.OrderStatusEnum;

public interface OrderStatusService {

	void saveOrderStatus(OrderStatus orderStatus);
	void updateOrderStatus(OrderStatus orderStatus);
	OrderStatus getOrderStatusById(Long id);
	void deleteById(Long id);
	List<OrderStatus> findAll();
	OrderStatus getOrderStatusByEnum(OrderStatusEnum orderStatusEnum);
}
