package com.terrance.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.terrance.entity.Room;
import com.terrance.repo.RoomRepo;

@Service
public class RoomServiceImpl implements RoomService{
	
	
	@Autowired
	RoomRepo roomrepo;

	public List<Room> getList(int id) {
		List<Room> list = (List<Room>) roomrepo.findAll();
		List<Room> hotelList = new ArrayList<Room>();
			
		for(Room r: list) {
			if(id == r.getHotel().getId()) {
				hotelList.add(r);
			}
		}
		
		return hotelList;
	}

	@Override
	@Transactional
	public void addRoomNumbers(int id) {
		//roomrepo.findall().stream().filter(Room -> Room.getHotel().getId() == id).collect(Collectors.toList());
		List<Room> list = getList(id);
		for(int i = 0; i<list.size();i++) {
			list.get(i).setRoomNumber(i+1);
			roomrepo.save(list.get(i));
		}
	}

	@Override
	public void setRoomDetails(String bedType, String smoking, double rate, int roomNumber, int hotelId) {
		// TODO Auto-generated method stub
		List<Room> list = getList(hotelId);
		for(Room r: list) {
			if(r.getRoomNumber()== roomNumber) {
				r.setBedType(bedType);
				r.setSmoking(smoking);
				r.setRate(rate);
				r.setOccupied(false);
				roomrepo.save(r);
			}
		}
		
	}

	@Override
	public void setOcupant(String name) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void printAllRooms(int hotelId) {
		for(Room r: getList(hotelId)) {
			System.out.println(r);
		}
		
	}

	@Override
	public Room getRoom(int id) {
		Room r = roomrepo.findById(id).get();
		return r;
	}
	
}
