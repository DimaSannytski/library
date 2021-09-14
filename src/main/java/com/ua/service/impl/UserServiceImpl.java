package com.ua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.dao.UserDao;
import com.ua.entity.User;
import com.ua.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
//	@Autowired
//	PasswordEncoder passwordEncoder;
	
	@Override
	public void save(User user) {
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.saveUser(user);
		
	}

	@Override
	public void update(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}

	@Override
	public void deleteById(Long id) {
		userDao.deleteById(id);
		
	}

	@Override
	public List<User> findAll() {

		return userDao.findAll();
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}



}
