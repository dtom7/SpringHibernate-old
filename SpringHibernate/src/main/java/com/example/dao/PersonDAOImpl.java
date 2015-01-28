package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Event;
import com.example.domain.Person;

@Repository("personDAOImpl")
public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean addPerson(Person person, Event... events) {
		
		for (Event event:events) {
			person.getEventList().add(event);
			event.getPersonList().add(person);
			sessionFactory.getCurrentSession().save(event);
		}
		
		sessionFactory.getCurrentSession().save(person);
		
		return true;
	}

	@Override
	@Transactional
	public Person getPerson(int id) {
		return (Person)sessionFactory.getCurrentSession().get(Person.class, id);
	}

}
