package com.ua.service;

import java.util.List;

import com.ua.entity.BookCopy;

public interface BookCopyService {

	void saveBookCopy(BookCopy bookCopy);
	void updateBookCopy(BookCopy bookCopy);
	BookCopy getBookCopyById(Long id);
	void deleteById(Long id);
	List<BookCopy> findAll();
}
