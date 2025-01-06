package com.ua.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ua.dao.BookStatusDao;
import com.ua.entity.BookStatus;

@Repository
public class BookStatusDaoImpl implements BookStatusDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveBookStatus(BookStatus bookStatus) {
		bookStatus.setCreatedAt(new Date());
		bookStatus.setUpdatedAt(new Date());
		getSessionFactory().save(bookStatus);
	}

	@Override
	public void updateBookStatus(BookStatus bookStatus) {
		bookStatus.setUpdatedAt(new Date());
		getSessionFactory().update(bookStatus);
	}

	@Override
	public BookStatus getBookStatusById(Long id) {
		return (BookStatus) getSessionFactory().get(BookStatus.class, id);
	}

	@Override
	public void deleteById(Long id) {
		BookStatus bookStatus = getBookStatusById(id);
		if (bookStatus != null) {
			getSessionFactory().delete(bookStatus);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookStatus> findAll() {
		return getSessionFactory().createQuery("from BookStatus").list();
	}
}
