package com.ua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.dao.GenreDao;
import com.ua.entity.Genre;
import com.ua.service.GenreService;

@Transactional
@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	GenreDao genreDao;
	
	@Override
	public void saveGenre(Genre genre) {
		genreDao.saveGenre(genre);
	}

	@Override
	public void updateGenre(Genre genre) {
		genreDao.updateGenre(genre);
	}

	@Override
	public Genre getGenreById(Long id) {
		return genreDao.getGenreById(id);
	}

	@Override
	public void deleteById(Long id) {
		genreDao.deleteById(id);
	}

	@Override
	public List<Genre> findAll() {
		return genreDao.findAll();
	}
}
