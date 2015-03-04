package com.sreeven.timetrack.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sreeven.timetrack.domain.User;

@Repository("userDAOImpl")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	@Transactional
	public User getUserByEmail(String email) {
		return null;
	}

	@Override
	@Transactional
	public Long createUser(User user) {
		Long id = (Long)sessionFactory.getCurrentSession().save(user);
		return id;
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		User obj = (User)sessionFactory.getCurrentSession().merge(user);
		return obj;
	}

	@Override
	@Transactional
	public User getUserById(Long id) {
		User user = (User)sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);		
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
