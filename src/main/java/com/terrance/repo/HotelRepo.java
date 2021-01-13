package com.terrance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.terrance.entity.Hotel;
import com.terrance.entity.Room;

public interface HotelRepo extends CrudRepository<Hotel, Integer> {

	@Query(value = "Select * from rooms where hotel_id = ?1", nativeQuery = true)
	public List<Room> findRoomsByHotelId(int id);
	
}
