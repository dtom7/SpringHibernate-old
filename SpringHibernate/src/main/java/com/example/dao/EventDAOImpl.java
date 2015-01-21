package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Event;

@Repository("eventDAOImpl")
public class EventDAOImpl implements EventDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		System.out.println("getSessionFactory .. ");
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("setSessionFactory .. " + sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	@Override
    @Transactional
	public boolean createEvent(Event event) {
		System.out.println("sessionFactory: " + sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session: " + session);
		sessionFactory.getCurrentSession().save(event);
		return true;
		/*
		try {
			System.out.println("Transaction: " + sessionFactory.getCurrentSession().getTransaction());
			sessionFactory.getCurrentSession().getTransaction().begin();
			sessionFactory.getCurrentSession().save(event);
			sessionFactory.getCurrentSession().getTransaction().commit();
			return true;
		} catch (Exception e) {
				sessionFactory.getCurrentSession().getTransaction().rollback();
			System.err.println(e);
			return false;
		} 
		*/
	}

	@Override
	public boolean deleteEvent(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Event getEvent(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEvent(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

}
