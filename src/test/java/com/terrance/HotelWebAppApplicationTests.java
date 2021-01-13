package com.terrance;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.terrance.entity.*;
import com.terrance.services.*;

@SpringBootTest
class HotelWebAppApplicationTests {

	@Autowired
	HotelService hservice;

	@Autowired
	RoomService rservice;
	
	
	
	//Hotel hotelC = new Hotel(1, "Hotel California", "San Francisco");
	
	@Test
	void contextLoads() {
	}

	@Test
	void getAllRooms() {
		List<Room> list= hservice.getRooms(1);
		
		for(Room r : list) {
	//		System.out.println(r);
		}	
	}
	
	@Test
	void makeOrCancelReservation() {
		//hservice.addReservation("Terrance", "n", "king", 1);
	//	hservice.cancelReservation("Terrance", 1);
	//	hservice.cancelReservation("Terrance Stevenson", 1);
	}
	
	@Test
	void updateRooms() {
//		rservice.addRoomNumbers(2);
//		rservice.addRoomNumbers(3);
//		rservice.setRoomDetails("king", "n", 20.00, 1, 2);
//		rservice.setRoomDetails("king", "n", 20.00, 2, 2);
//		rservice.setRoomDetails("double", "n", 40.00, 3, 2);
//		rservice.setRoomDetails("king", "n", 20.00, 1, 3);
//		rservice.setRoomDetails("king", "n", 20.00, 2, 3);
//		rservice.setRoomDetails("double", "n", 40.00, 3, 3);
	}
	
	
	@Test
	void addGetHotels() {
//		Hotel hotelA = new Hotel(2, "The Curtis Hotel"," Denver");
//		Hotel hotelB = new Hotel(3, "Hotel Pennsylvania", "New York");
//		hservice.addHotel(hotelA);
//		hservice.addHotel(hotelB);
		
//		List<Hotel> hlist = hservice.getHotels();
//		for(Hotel h : hlist) {
//			System.out.println(h);
//		}
		
		//hservice.addHotel(hotelA);
		//hservice.addHotel(hotelB)	
	}
	
	@Test
	void addRoom() {
//		hservice.addRoom(2);
//		hservice.addRoom(2);
//		hservice.addRoom(2);
//		hservice.addRoom(3);
//		hservice.addRoom(3);
//		hservice.addRoom(3);
		
	}
	
}
