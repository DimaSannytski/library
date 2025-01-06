package com.ua.dao;

import java.util.List;

import com.ua.entity.Genre;

public interface GenreDao {
	void saveGenre(Genre genre);
	void updateGenre(Genre genre);
	Genre getGenreById(Long id);
	void deleteById(Long id);
	List<Genre> findAll();
}
