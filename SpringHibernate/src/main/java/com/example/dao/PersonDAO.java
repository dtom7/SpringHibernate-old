package com.example.dao;

import com.example.domain.Person;

public interface PersonDAO {
	
	boolean addPerson(Person person);
	Person getPerson(int id);

}
