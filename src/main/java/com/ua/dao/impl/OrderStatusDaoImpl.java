package com.ua.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ua.dao.OrderStatusDao;
import com.ua.entity.OrderStatus;

@Repository
public class OrderStatusDaoImpl implements OrderStatusDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSessionFactory() {
		
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveOrderStatus(OrderStatus orderStatus) {
		orderStatus.setCreatedAt(new Date());
		orderStatus.setUpdatedAt(new Date());
		getSessionFactory().save(orderStatus);
		
	}

	@Override
	public void updateOrderStatus(OrderStatus orderStatus) {
		orderStatus.setUpdatedAt(new Date());
		getSessionFactory().update(orderStatus);
		
	}

	@Override
	public OrderStatus getOrderStatusById(Long id) {
		return (OrderStatus) getSessionFactory().get(OrderStatus.class, id);
	}

	@Override
	public void deleteById(Long id) {
		OrderStatus orderStatus = getOrderStatusById(id);
		if (orderStatus != null) {
			getSessionFactory().delete(orderStatus);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderStatus> findAll() {
		return getSessionFactory().createQuery("from OrderStatus").list();
	}

//	@Override
//	public OrderStatus getOrderStatusByEnum(OrderStatusEnum orderStatusEnum) {
//		try {
//			return (OrderStatus) getSessionFactory().createQuery("SELECT u FROM OrderStatus u WHERE u.orderStatusEnum = :orderStatusEnum")
//					.setParameter("orderStatusEnum", orderStatusEnum).getSingleResult();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}

}
