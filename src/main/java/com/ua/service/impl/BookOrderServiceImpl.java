package com.ua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.constants.OrderStatusConst;
import com.ua.dao.BookOrderDao;
import com.ua.entity.Book;
import com.ua.entity.BookOrder;
import com.ua.entity.User;
import com.ua.service.BookOrderService;
import com.ua.service.OrderStatusService;

@Transactional
@Service
public class BookOrderServiceImpl implements BookOrderService {

	@Autowired
	BookOrderDao bookOrderDao;
	@Autowired
	OrderStatusService orderStatusService;
	
	@Override
	public void saveBookOrder(BookOrder bookOrder) {
		bookOrderDao.saveBookOrder(bookOrder);
	}

	@Override
	public void updateBookOrder(BookOrder bookOrder) {
		bookOrderDao.updateBookOrder(bookOrder);
	}

	@Override
	public BookOrder getBookOrderById(Long id) {
		return bookOrderDao.getBookOrderById(id);
	}

	@Override
	public void deleteById(Long id) {
		bookOrderDao.deleteById(id);
	}

	@Override
	public List<BookOrder> findAll() {
		return bookOrderDao.findAll();
	}

	@Override
	public void createOrder(Book book, User user) {
		BookOrder bookOrder = new BookOrder();
		bookOrder.setBook(book);
		bookOrder.setReader(user);
		bookOrder.setOrderStatus(orderStatusService.getOrderStatusById(OrderStatusConst.CREATED));
		bookOrderDao.saveBookOrder(bookOrder);
	}

	@Override
	public List<BookOrder> findAllByStatusIdByUserId(Long userid, Long statusId) {
		return bookOrderDao.findAllByStatusIdByUserId(userid, statusId);
	}

	@Override
	public List<BookOrder> findAllByStatusId(long statusId) {
		return bookOrderDao.findAllByStatusId(statusId);
	}
}
