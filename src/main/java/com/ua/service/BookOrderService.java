package com.ua.service;

import java.util.List;

import com.ua.entity.Book;
import com.ua.entity.BookOrder;
import com.ua.entity.User;

public interface BookOrderService {

	void saveBookOrder(BookOrder bookOrder);
	void updateBookOrder(BookOrder bookOrder);
	BookOrder getBookOrderById(Long id);
	void deleteById(Long id);
	List<BookOrder> findAll();
	
	void createOrder(Book book, User user);
	
	List<BookOrder> findAllByStatusIdByUserId(Long userId, Long statusId);
	
	List<BookOrder> findAllByStatusId(long statusId);
}
