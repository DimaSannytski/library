package com.ua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.dao.OrderStatusDao;
import com.ua.entity.OrderStatus;
import com.ua.entity.enums.OrderStatusEnum;
import com.ua.service.OrderStatusService;

@Transactional
@Service
public class OrderStatusServiceImpl implements OrderStatusService{

	@Autowired
	OrderStatusDao orderStatusDao;
	
	@Override
	public void saveOrderStatus(OrderStatus orderStatus) {
		orderStatusDao.saveOrderStatus(orderStatus);
		
	}

	@Override
	public void updateOrderStatus(OrderStatus orderStatus) {
		orderStatusDao.updateOrderStatus(orderStatus);
		
	}

	@Override
	public OrderStatus getOrderStatusById(Long id) {
		
		return orderStatusDao.getOrderStatusById(id);
	}

	@Override
	public void deleteById(Long id) {
		orderStatusDao.deleteById(id);
		
	}

	@Override
	public List<OrderStatus> findAll() {
		
		return orderStatusDao.findAll();
	}

	@Override
	public OrderStatus getOrderStatusByEnum(OrderStatusEnum orderStatusEnum) {
		
		return orderStatusDao.getOrderStatusByEnum(orderStatusEnum);
	}

}
