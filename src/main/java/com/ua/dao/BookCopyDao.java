package com.ua.dao;

import java.util.List;

import com.ua.entity.BookCopy;

public interface BookCopyDao {
	void saveBookCopy(BookCopy bookCopy);
	void updateBookCopy(BookCopy bookCopy);
	BookCopy getBookCopyById(Long id);
	void deleteById(Long id);
	List<BookCopy> findAll();
}
