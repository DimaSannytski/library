package com.ua.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ua.dao.BookDao;
import com.ua.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveBook(Book book) {
		book.setCreatedAt(new Date());
		book.setUpdatedAt(new Date());
		getSessionFactory().save(book);
	}

	@Override
	public void updateBook(Book book) {
		book.setUpdatedAt(new Date());
		getSessionFactory().update(book);
	}

	@Override
	public Book getBookById(Long id) {
		return (Book) getSessionFactory().get(Book.class, id);
	}

	@Override
	public void deleteById(Long id) {
		Book book = getBookById(id);
		if (book != null) {
			getSessionFactory().delete(book);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		return getSessionFactory().createQuery("from Book").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByTitle(String title) {
			return  getSessionFactory().createQuery("SELECT u FROM Book u WHERE u.title like :title")
					.setParameter("title", title).list();
	
	}
}
