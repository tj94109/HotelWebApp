package com.terrance.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terrance.entity.Hotel;
import com.terrance.entity.Room;
import com.terrance.repo.HotelRepo;
import com.terrance.repo.RoomRepo;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepo hotelrepo;

	@Autowired 
	private RoomRepo roomrepo;
	
	@Override
	@Transactional
	public void addHotel(Hotel myHotel) {
		hotelrepo.save(myHotel);
	}
	
	@Override
	@Transactional
	public void addRoom(int id) {
		Optional<Hotel> optional = hotelrepo.findById(id);
		Hotel hotel = optional.get();
		hotel.addRoom();
		hotelrepo.save(hotel);
	}
	
	public List<Hotel> getHotels() {
		List<Hotel> hlist = (List<Hotel>) hotelrepo.findAll();
		return hlist;
	}
	
	public Hotel getHotel(int id) {
		Hotel h = hotelrepo.findById(id).get();
		return h;
	}
	
	@Transactional
	public void deleteHotels() {
		hotelrepo.deleteAll();
	}

	@Override
	@Transactional
	public void addReservation(String name, String smoking, String bedType, int HotelId) {
		List<Room> list = (List<Room>) roomrepo.findAll();
		for(Room r: list) {
			if(r.isOccupied()==false) {
				if(bedType.equalsIgnoreCase(r.getBedType()) && r.getSmoking().equalsIgnoreCase(smoking)) {
					r.setOccupantName(name);
					r.setOccupied(true);
					roomrepo.save(r);
					System.out.println("Reservation made for: " + r.getOccupantName());
					break;
				}
			}else{
				System.out.println("Reservation not made");
			}
		}	
		
	}
	
	@Override
	@Transactional
	public void cancelReservation(String name, int hotelID) {
		List<Room> list = (List<Room>) roomrepo.findAll();
		for(Room r: list) {
			if(r.getOccupantName().equalsIgnoreCase(name)) {
				System.out.println("Reservation cancelled for: " + r.getOccupantName());
				r.setOccupantName("Not Occupied");
				r.setOccupied(false);
				
			}else {
				System.out.println("NOT FOUND");
			}
		}
	}
	

	@Override
	public List<Room> getRooms(int id) {
		Hotel h = hotelrepo.findById(id).get();
		Set<Room>rSet = h.getRooms();
		List<Room> rList = new ArrayList<Room>();
		for(Room r : rSet) {
			rList.add(r);
		}
		return rList;
	}

}
