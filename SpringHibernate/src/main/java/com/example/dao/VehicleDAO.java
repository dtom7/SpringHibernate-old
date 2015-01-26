package com.example.dao;

import com.example.domain.Vehicle;

public interface VehicleDAO {
	
	boolean createVehicle(Vehicle vehicle);
	Vehicle getVehicle(int id);

}
