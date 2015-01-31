package com.example.dao;

import com.example.domain.Animal;

public interface GenericDAO<T extends Animal> {
	
	boolean create(T t);
	T read(int id);
	boolean update(T t);
	void setClazz(Class<T> clazz);

}
