package com.ua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.dao.BookCopyDao;
import com.ua.entity.BookCopy;
import com.ua.service.BookCopyService;

@Transactional
@Service
public class BookCopyServiceImpl implements BookCopyService {

	@Autowired
	BookCopyDao bookCopyDao;
	
	@Override
	public void saveBookCopy(BookCopy bookCopy) {
		bookCopyDao.saveBookCopy(bookCopy);
	}

	@Override
	public void updateBookCopy(BookCopy bookCopy) {
		bookCopyDao.updateBookCopy(bookCopy);
	}

	@Override
	public BookCopy getBookCopyById(Long id) {
		return bookCopyDao.getBookCopyById(id);
	}

	@Override
	public void deleteById(Long id) {
		bookCopyDao.deleteById(id);
	}

	@Override
	public List<BookCopy> findAll() {
		return bookCopyDao.findAll();
	}
}
