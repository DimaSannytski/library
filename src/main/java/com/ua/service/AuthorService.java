package com.ua.service;

import java.util.List;

import com.ua.entity.Author;

public interface AuthorService {
	void saveAuthor(Author author);
	void updateAuthor(Author author);
	Author getAuthorById(Long id);
	void deleteById(Long id);
	List<Author> findAll();
	List<Author> findAllByName(String name);
}
