package com.terrance.repo;

import org.springframework.data.repository.CrudRepository;

import com.terrance.entity.Room;

public interface RoomRepo extends CrudRepository<Room, Integer> {

	
}

