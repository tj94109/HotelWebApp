package com.terrance.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hotelName;
	private String location;
	private static int OccupiedCount;
	
	@OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	
	private Set<Room> rooms = new HashSet<Room>();
	
	private int numberOfRooms = rooms.size();
	
	
	public Hotel(int id, String hotelName, String location) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.location = location;
		
	}
	
	public Hotel() {}

//	public void addRoom(int roomNumber,String bed, String smoking, double rate) {
//		Room newRoom = new Room(roomNumber,bed,smoking,rate);
//		rooms.add(newRoom);
//	}
	
	public void addRoom() {
		Room room = new Room(0,"full", "n", 0.00);
		room.setHotel(this);
		rooms.add(room);
		
	}
	
	public void addReservation(String name, String smoking, String bedType) {
		System.out.println(name+ " " + smoking + " " + bedType + " \n");
		for(Room r: rooms) {
			if(!(r==null)) {
				if(r.isOccupied()==false) {
					System.out.println(r);
					if(r.getBedType().equalsIgnoreCase(bedType) && r.getSmoking().equalsIgnoreCase(smoking)) { //
						System.out.println("WORKING");
						r.setOccupantName(name);
						r.setOccupied(true);
						OccupiedCount++;
						System.out.println("Reservation made for: " + r.getOccupantName());
						break;
					}else {
						System.out.println("Reservation not made.");
						break;
					}
				}
			}	
			
		}
	}
	
	public Set<Room> getRooms(){
		return rooms;
	}
	
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public int getOccupiedCount() {
		return OccupiedCount;
	}

	public void setOccupiedCount(int occupiedCount) {
		OccupiedCount = occupiedCount;
	}

	public int getNumberOfRooms() {
		return numberOfRooms = rooms.size();
	}
	
	@Override
	public String toString() {
		return "\n[Hotel ID = " + id + 
				", \nName = " + this.hotelName + 
				", \nLocation = " + this.location + 
				", \nNumber Of Rooms = "+ this.getNumberOfRooms() + 
				", \nRooms Occupied = " + this.OccupiedCount + 
				"]\n";
	}

}