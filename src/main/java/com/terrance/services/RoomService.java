package com.terrance.services;

import java.util.List;

import com.terrance.entity.Room;

public interface RoomService {

	public List<Room> getList(int id);
	
	public void addRoomNumbers(int id);
	
	public void setRoomDetails(String bedType,String smoking, double rate, int RoomNumber, int hotelId);
	
	public void printAllRooms(int hotelId);

	public void setOcupant(String name);
	
	public Room getRoom(int id);
}
