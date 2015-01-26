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
		VehicleDAO vehicleDAO = (VehicleDAO) context.getBean("vehicleDAOImpl"); 
		
		Person person = new Person();
		person.setName("Dan");
		
		Vehicle vehicle1 = new Vehicle("suv");
		Vehicle vehicle2 = new Vehicle("car");
		
		vehicle1.setPerson(person);
		vehicle2.setPerson(person);
		
        person.getVehicleList().add(vehicle1);
        person.getVehicleList().add(vehicle2);

		try {
			System.out.println(personDAO.addPerson(person));
			//System.out.println(vehicleDAO.createVehicle(vehicle1));
			//System.out.println(vehicleDAO.createVehicle(vehicle2));
			//System.out.println(personDAO.addPerson(person));
		} catch (Exception e) {
			System.err.println("Exception: " +  e);
		}
		person = null;
		try {
			person = personDAO.getPerson(1);
		} catch (Exception e) {
			System.err.println("Exception: " +  e);
		}
		
		
		
	}

}
