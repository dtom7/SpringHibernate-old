package com.example.main;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.EventDAO;
import com.example.dao.EventDAOImpl;
import com.example.domain.Event;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		EventDAO eventDAO = (EventDAO) context.getBean("eventDAOImpl"); // new
																		// EventDAOImpl();
		Event event = new Event();
		event.setId("KU1008");
		event.setDate(new Date());
		event.setTitle("Test Event");
		try {
			System.out.println(eventDAO.createEvent(event));
		} catch (Exception e) {
			System.err.println("Exception: " +  e.getMessage());
		}

	}

}
