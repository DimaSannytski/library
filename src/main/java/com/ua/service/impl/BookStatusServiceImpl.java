package com.ua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.dao.BookStatusDao;
import com.ua.entity.BookStatus;
import com.ua.service.BookStatusService;

@Transactional
@Service
public class BookStatusServiceImpl implements BookStatusService{

	@Autowired
	BookStatusDao bookStatusDao;
	
	@Override
	public void saveBookStatus(BookStatus bookStatus) {
		bookStatusDao.saveBookStatus(bookStatus);
		
	}

	@Override
	public void updateBookStatus(BookStatus bookStatus) {
		bookStatusDao.updateBookStatus(bookStatus);
		
	}

	@Override
	public BookStatus getBookStatusById(Long id) {

		return bookStatusDao.getBookStatusById(id);
	}

	@Override
	public void deleteById(Long id) {
		bookStatusDao.deleteById(id);
		
	}

	@Override
	public List<BookStatus> findAll() {
	
		return bookStatusDao.findAll();
	}

}
