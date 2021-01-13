package com.terrance.services;

import java.util.List;

import com.terrance.entity.Hotel;
import com.terrance.entity.Room;

public interface HotelService {

	public void addHotel(Hotel myHotel);
	
	public void addRoom(int id);
	
	public List<Hotel> getHotels();
	
	public List<Room> getRooms(int id);
	
	public Hotel getHotel(int id);
	
	public void deleteHotels();
	
	public void addReservation(String name, String smoking, String bedType, int HotelId);
	
	public void cancelReservation(String name, int hotelID);
}
