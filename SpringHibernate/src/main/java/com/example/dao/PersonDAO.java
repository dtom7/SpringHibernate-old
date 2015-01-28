package com.example.dao;

import com.example.domain.Event;
import com.example.domain.Person;

public interface PersonDAO {
	
	boolean addPerson(Person person, Event... events);
	Person getPerson(int id);

}
