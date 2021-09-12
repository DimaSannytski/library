package com.ua.dao;

import java.util.List;

import com.ua.entity.BookStatus;

public interface BookStatusDao {

	void saveBookStatus(BookStatus bookStatus);
	void updateBookStatus(BookStatus bookStatus);
	BookStatus getBookStatusById(Long id);
	void deleteById(Long id);
	List<BookStatus> findAll();
}
