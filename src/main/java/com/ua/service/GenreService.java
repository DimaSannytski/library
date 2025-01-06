package com.ua.service;

import java.util.List;

import com.ua.entity.Genre;

public interface GenreService {
	void saveGenre(Genre genre);
	void updateGenre(Genre genre);
	Genre getGenreById(Long id);
	void deleteById(Long id);
	List<Genre> findAll();
}
