package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Vehicle;

@Repository("vehicleDAOImpl")
public class VehicleDAOImpl implements VehicleDAO {
	
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
	public boolean createVehicle(Vehicle vehicle) {
		sessionFactory.getCurrentSession().save(vehicle);
		return true;
	}

	@Override
	@Transactional
	public Vehicle getVehicle(int id) {
      return (Vehicle) sessionFactory.getCurrentSession().get(Vehicle.class, id);
	}

}
