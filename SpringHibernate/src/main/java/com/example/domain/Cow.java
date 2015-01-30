package com.example.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Cow extends Animal {
	
	private int milkQuantity;

	public Cow() {
		super();
	}

	public Cow(String name, int numLegs, int milkQuantity) {
		super(name, numLegs);
		this.milkQuantity = milkQuantity;
	}

	public int getMilkQuantity() {
		return milkQuantity;
	}

	public void setMilkQuantity(int milkQuantity) {
		this.milkQuantity = milkQuantity;
	}

}
