package com.terrance.entity;

import org.springframework.stereotype.Component;

@Component
public class Guest {

	private String name, smoking,bed;
	
	public Guest() {
		
	}
	
	public Guest(String name, String smoking, String bed) {
		this.name = name;
		this.smoking = smoking;
		this.bed = bed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}
	
	
	
	
}
