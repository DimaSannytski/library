package com.ua.service;

import java.util.List;

import com.ua.entity.BookOrder;

public interface BookOrderService {

	void saveBookOrder(BookOrder bookOrder);
	void updateBookOrder(BookOrder bookOrder);
	BookOrder getBookOrderById(Long id);
	void deleteById(Long id);
	List<BookOrder> findAll();
}
