package com.ua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.dao.BookOrderDao;
import com.ua.entity.BookOrder;
import com.ua.service.BookOrderService;

@Transactional
@Service
public class BookOrderServiceImpl implements BookOrderService{

	@Autowired
	BookOrderDao bookOrderDao;
	
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

}
