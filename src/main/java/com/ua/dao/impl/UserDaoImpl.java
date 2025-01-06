package com.ua.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ua.dao.UserDao;
import com.ua.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveUser(User user) {
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		getSessionFactory().save(user);
	}

	@Override
	public void updateUser(User user) {
		user.setUpdatedAt(new Date());
		getSessionFactory().update(user);
	}

	@Override
	public User getUserById(Long id) {
		return (User) getSessionFactory().get(User.class, id);
	}

	@Override
	public void deleteById(Long id) {
		User user = getUserById(id);
		if (user != null) {
			getSessionFactory().delete(user);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return getSessionFactory().createQuery("from User").list();
	}

	@Override
	public User findByEmail(String email) {
		try {
			return (User) getSessionFactory().createQuery("SELECT u FROM User u WHERE u.email = :email")
					.setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
