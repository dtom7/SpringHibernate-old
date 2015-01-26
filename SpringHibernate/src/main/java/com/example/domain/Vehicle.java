package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	//@JoinTable(name="PERSON_VEHICLE", joinColumns=@JoinColumn(name="VEHICLE_ID"),
	//inverseJoinColumns=@JoinColumn(name="PERSON_ID"))
	private Person person;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String name) {
		super();
		this.name = name;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
