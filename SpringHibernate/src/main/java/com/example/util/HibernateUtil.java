package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the Configuration from hibernate.cfg.xml
        	Configuration config = new Configuration().configure();
        	// Build a Registry with our configuration properties
        	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
        	config.getProperties()).buildServiceRegistry();
        	// Create the session factory and return it
        	return config.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
