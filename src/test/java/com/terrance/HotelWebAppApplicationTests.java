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

//	Hotel hotelA = new Hotel(1, "Hotel California", "San Francisco");		
//	Hotel hotelB = new Hotel(2, "The Curtis Hotel"," Denver");
//	Hotel hotelC = new Hotel(3, "Hotel Pennsylvania", "New York");

	@Test
	void contextLoads() {
	}

	@Test
	void getAllRooms() {

//		List<Hotel> list = hservice.getHotels();
//		
//		for(Hotel h: list) {
//			System.out.println(h);
//		}	
	}
	
	@Test
	void makeOrCancelReservation() {
		//hservice.addReservation("Terrance", "n", "king", 1);
	//	hservice.cancelReservation("Terrance", 1);
	//	hservice.cancelReservation("Terrance Stevenson", 1);
	}
		
	@Test
	void addGetHotels() {//Create and Add hotels to db and add Rooms
	
//		hservice.addHotel(hotelA);
//		hservice.addHotel(hotelB);
//		hservice.addHotel(hotelC);
	}
	
	@Test
	void addRoom() { // add rooms to each hotel

//		hservice.addRoom(1);
//		hservice.addRoom(1);
//		hservice.addRoom(1);
//		hservice.addRoom(2);
//		hservice.addRoom(2);
//		hservice.addRoom(2);
//		hservice.addRoom(3);
//		hservice.addRoom(3);
//		hservice.addRoom(3);
		
	}
	
	@Test
	void updateRooms() {  //add room numbers to hotel id and set up each room detail
//		rservice.addRoomNumbers(1);
//		rservice.addRoomNumbers(2);
//		rservice.addRoomNumbers(3);

//		rservice.setRoomDetails("king", "n", 20.00, 1, 1);
//		rservice.setRoomDetails("king", "n", 20.00, 2, 1);
//		rservice.setRoomDetails("double", "n", 40.00, 3, 1);
//		rservice.setRoomDetails("king", "n", 20.00, 1, 2);
//		rservice.setRoomDetails("king", "n", 20.00, 2, 2);
//		rservice.setRoomDetails("double", "n", 40.00, 3, 2);
//		rservice.setRoomDetails("king", "n", 20.00, 1, 3);
//		rservice.setRoomDetails("king", "n", 20.00, 2, 3);
//		rservice.setRoomDetails("double", "n", 40.00, 3, 3);
	}
}
