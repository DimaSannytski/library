package com.ua.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ua.dao.GenreDao;
import com.ua.entity.Genre;

@Repository
public class GenreDaoImpl implements GenreDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveGenre(Genre genre) {
		genre.setCreatedAt(new Date());
		genre.setUpdatedAt(new Date());
		getSessionFactory().save(genre);
	}

	@Override
	public void updateGenre(Genre genre) {
		genre.setUpdatedAt(new Date());
		getSessionFactory().update(genre);
	}

	@Override
	public Genre getGenreById(Long id) {
		return (Genre) getSessionFactory().get(Genre.class, id);
	}

	@Override
	public void deleteById(Long id) {
		Genre genre = getGenreById(id);
		if (genre != null) {
			getSessionFactory().delete(genre);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> findAll() {
		return getSessionFactory().createQuery("from Genre").list();
	}
}
