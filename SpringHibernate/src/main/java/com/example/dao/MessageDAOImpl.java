package com.example.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Message;

@Repository("messageDAOImpl")
@Transactional
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Message createMessage(Message message) {
		sessionFactory.getCurrentSession().save(message);
		return message;
	}

	@Override
	public Message retrieveMessage(long id) {
		return (Message) sessionFactory.getCurrentSession().get(Message.class,
				id);
	}

	@Override
	public boolean deleteMessage(long id) {
		Message message = (Message) sessionFactory.getCurrentSession().get(
				Message.class, id);
		if (message != null) {
			sessionFactory.getCurrentSession().delete(message);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateMessage(Message message) {
		sessionFactory.getCurrentSession().saveOrUpdate(message);
		return true;
	}

}
