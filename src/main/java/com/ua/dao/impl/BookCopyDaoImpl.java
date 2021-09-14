package com.ua.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ua.dao.BookCopyDao;
import com.ua.entity.BookCopy;

@Repository
public class BookCopyDaoImpl implements BookCopyDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSessionFactory() {
		
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveBookCopy(BookCopy bookCopy) {
		bookCopy.setCreatedAt(new Date());
		bookCopy.setUpdatedAt(new Date());
		getSessionFactory().save(bookCopy);
		
	}

	@Override
	public void updateBookCopy(BookCopy bookCopy) {
		bookCopy.setUpdatedAt(new Date());
		getSessionFactory().update(bookCopy);
		
	}

	@Override
	public BookCopy getBookCopyById(Long id) {
		return (BookCopy) getSessionFactory().get(BookCopy.class, id);
	}

	@Override
	public void deleteById(Long id) {
		BookCopy bookCopy = getBookCopyById(id);
		if (bookCopy != null) {
			getSessionFactory().delete(bookCopy);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookCopy> findAll() {
		return getSessionFactory().createQuery("from BookCopy").list();
	}
}
