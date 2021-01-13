package com.terrance.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int roomNumber;
	String bedType;
	String OccupantName;
	String smoking;
	Double rate;
	boolean occupied;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "hotel_id", nullable = false)
	private Hotel hotel;
	
	public Room(int roomNumber, String bedType, String smoking, double rate) {
		this.roomNumber = roomNumber;
		this.bedType = bedType;
		this.OccupantName = "Not Occupied";
		this.smoking = smoking;
		this.rate = rate;
		this.occupied = false;
	}
	
	public Room() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	public String getOccupantName() {
		return OccupantName;
	}
	public void setOccupantName(String occupantName) {
		OccupantName = occupantName;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Hotel getHotel() {
		return this.hotel;
	}
	
	@Override
	public String toString() {
		return "\n[Room ID = " + id + 
				", \nName = " + this.OccupantName +
				", \nOccupied = " + this.occupied +
				", \nRoom Number = " + this.roomNumber +
				", \nBed Type = " + this.bedType +
				", \nSmoking = " + this.smoking +
				", \nRate = "+ this.getRate() + 
				"]\n";
	}
}