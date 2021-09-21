package com.ua.service;

import java.util.List;

import com.ua.entity.Book;

public interface BookService {


	void saveBook(Book book);
	void updateBook(Book book);
	Book getBookById(Long id);
	void deleteById(Long id);
	List<Book> findAll();
	List<Book> findByTitle(String title);
	
	void createBookCopys(Book book, int copyCount);
}
