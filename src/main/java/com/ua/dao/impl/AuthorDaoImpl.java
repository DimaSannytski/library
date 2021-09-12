package com.ua.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ua.dao.AuthorDao;
import com.ua.entity.Author;

public class AuthorDaoImpl implements AuthorDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSessionFactory() {
		
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveAuthor(Author author) {
		author.setCreatedAt(new Date());
		author.setUpdatedAt(new Date());
		getSessionFactory().save(author);
		
	}

	@Override
	public void updateAuthor(Author author) {
		author.setUpdatedAt(new Date());
		getSessionFactory().update(author);
		
	}

	@Override
	public Author getAuthorById(Long id) {

		return (Author) getSessionFactory().get(Author.class, id);
	}

	@Override
	public void deleteById(Long id) {
		Author author = getAuthorById(id);
		if (author == null) {
			getSessionFactory().delete(author);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> findAll() {

		return getSessionFactory().createQuery("from Author").list();
	}

}
