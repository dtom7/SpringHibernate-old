package com.example.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("lion")
public class Lion extends Animal {

	private int speed;

	public Lion() {
		super();
	}

	public Lion(String name, int numLegs, int speed) {
		super(name, numLegs);
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	

}
