package com.example.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Animal;

@Repository("genericDAOImpl")
@Scope(value="prototype")
public class GenericDAOImpl<T extends Animal> implements GenericDAO<T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Class<T> clazz;

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	@Transactional
	public boolean create(T t) {
		sessionFactory.getCurrentSession().save(t);
		return true;
	}

	@Override
	@Transactional
	public boolean update(T t) {
		//T t1 = (T)sessionFactory.getCurrentSession().get(clazz, t.getId());
		sessionFactory.getCurrentSession().merge(t);
		return true;
	}

	@Override
	@Transactional
	public T read(int id) {
		T t = (T)sessionFactory.getCurrentSession().get(clazz, id);
		return t;
	}

}
