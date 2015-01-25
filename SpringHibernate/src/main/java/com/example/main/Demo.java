package com.example.main;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.EventDAO;
import com.example.dao.EventDAOImpl;
import com.example.dao.JobDAO;
import com.example.dao.JobDAOImpl;
import com.example.domain.Event;
import com.example.domain.Job;
import com.example.domain.JobKey;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		JobDAO jobDAO = (JobDAO) context.getBean("jobDAOImpl"); 
		
		Job job = new Job();
		JobKey jobKey = new JobKey(1000, 0, new Date(), 0);
		job.setJobkey(jobKey);
		job.setEmplStatus("A");																

		try {
			System.out.println(jobDAO.createJob(job));
		} catch (Exception e) {
			System.err.println("Exception: " +  e.getMessage());
		}

	}

}
