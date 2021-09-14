package com.ua.service;

import java.util.List;

import com.ua.entity.User;

public interface UserService {

	void save(User user);

	void update(User user);
	User getUserById(Long id);
	void deleteById(Long id);
	List<User> findAll();
	
	User findByEmail(String email);
}
