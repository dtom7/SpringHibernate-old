package com.example.dao;

import com.example.domain.Event;

public interface EventDAO {
	
	boolean createEvent(Event event);
	boolean deleteEvent(Event event);
	Event getEvent(Long id);
	boolean updateEvent(Event event);
	

}
