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
import com.sreeven.timetrack.dao.UserDAO;
import com.sreeven.timetrack.domain.User;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		//PersonDAO personDAO = (PersonDAO) context.getBean("personDAOImpl");
		//EventDAO eventDAO = (EventDAO) context.getBean("eventDAOImpl");

		UserDAO userDAO = (UserDAO) context.getBean("userDAOImpl");
		System.out.println("Starting ..");
		
		User user = new User();
		user.setEmail("test@test.com");
		user.setName("Test User");
		user.setPassword("password");
		user.setStatus("A");
		
		Long id = userDAO.createUser(user);
		System.out.println("New user id: " + id);
		
		user = userDAO.getUserById(id);
		System.out.println("New user name: " + user.getName());
		
		user.setName("new name1");
		user = userDAO.updateUser(user);
		System.out.println("1Updated user name: " + user.getName());
		
		user.setName("new name2");
		user = userDAO.updateUser(user);
		System.out.println("2Updated user name: " + user.getName());
		
		userDAO.deleteUser(user);
		
		//user = userDAO.getUserById(id);
		System.out.println("After delete: " + userDAO.getUserById(id));
	}

}
