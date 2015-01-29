package com.example.dao;

public interface GenericDAO<T> {
	
	boolean create(T t);

}
