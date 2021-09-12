package com.ua.service;

import java.util.List;

import com.ua.entity.BookStatus;

public interface BookStatusService {

	void saveBookStatus(BookStatus bookStatus);
	void updateBookStatus(BookStatus bookStatus);
	BookStatus getBookStatusById(Long id);
	void deleteById(Long id);
	List<BookStatus> findAll();
}
