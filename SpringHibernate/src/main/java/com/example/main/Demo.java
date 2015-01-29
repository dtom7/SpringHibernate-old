package com.example.main;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.EventDAO;
import com.example.dao.EventDAOImpl;
import com.example.dao.GenericDAO;
import com.example.dao.JobDAO;
import com.example.dao.JobDAOImpl;
import com.example.dao.PersonDAO;
import com.example.dao.VehicleDAO;
import com.example.domain.Animal;
import com.example.domain.Cow;
import com.example.domain.Lion;
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

		//PersonDAO personDAO = (PersonDAO) context.getBean("personDAOImpl");
		//EventDAO eventDAO = (EventDAO) context.getBean("eventDAOImpl");
		GenericDAO<Animal> animalDAO = (GenericDAO<Animal>) context.getBean("genericDAOImpl");
		GenericDAO<Lion> lionDAO = (GenericDAO<Lion>) context.getBean("genericDAOImpl");
		GenericDAO<Cow> cowDAO = (GenericDAO<Cow>) context.getBean("genericDAOImpl");

		Animal animal = new Animal("Generic Animal", 4);
		Lion lion = new Lion("Asian Lion", 4, 10);
		Cow cow = new Cow("Lankan Cow", 4, 20);
		

		try {
			System.out.println(animalDAO.create(animal));
			System.out.println(lionDAO.create(lion));
			System.out.println(cowDAO.create(cow));

		} catch (Exception e) {
			System.err.println("Exception: " + e);
		}

	}

}
