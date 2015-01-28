package com.example.main;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.EventDAO;
import com.example.dao.EventDAOImpl;
import com.example.dao.JobDAO;
import com.example.dao.JobDAOImpl;
import com.example.dao.PersonDAO;
import com.example.dao.VehicleDAO;
import com.example.domain.Vehicle;
import com.example.domain.Address;
import com.example.domain.Event;
import com.example.domain.Job;
import com.example.domain.JobKey;
import com.example.domain.Person;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		PersonDAO personDAO = (PersonDAO) context.getBean("personDAOImpl");
		EventDAO eventDAO = (EventDAO) context.getBean("eventDAOImpl");

		Person person1 = new Person();
		person1.setName("Dan");

		Event event1 = new Event("LOL", new Date());
		Event event2 = new Event("MOL", new Date());



		try {
			System.out.println(personDAO.addPerson(person1, event1, event2));
			//System.out.println(eventDAO.createEvent(event1));
			//System.out.println(eventDAO.createEvent(event2));
			// System.out.println(personDAO.addPerson(person2));
			// System.out.println(vehicleDAO.createVehicle(vehicle1));
			// System.out.println(vehicleDAO.createVehicle(vehicle2));
			// System.out.println(personDAO.addPerson(person));
		} catch (Exception e) {
			System.err.println("Exception: " + e);
		}
		// person = null;
		try {
			// person = personDAO.getPerson(1);
			// System.out.println(person.getVehicleList().size());
		} catch (Exception e) {
			System.err.println("Exception: " + e);
		}

	}

}
