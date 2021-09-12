package com.ua.dao;

import java.util.List;

import com.ua.entity.User;

public interface UserDao {

	void saveUser(User user);
	void updateUser(User user);
	User getUserById(Long id);
	void deleteById(Long id);
	List<User> findAll();
	
	User findByEmail(String email);
}
