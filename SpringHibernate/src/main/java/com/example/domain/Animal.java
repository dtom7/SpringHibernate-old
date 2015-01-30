package com.example.domain;

import javax.annotation.Generated;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private int numLegs;
		
	public Animal() {
		super();
	}
	
	public Animal(String name, int numLegs) {
		super();
		this.name = name;
		this.numLegs = numLegs;
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
	public int getNumLegs() {
		return numLegs;
	}
	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}
	
}
