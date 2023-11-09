package com.example.room.service;

import java.util.Date;
import java.util.List;


import com.example.room.model.Room;

public interface RoomService {
	
	List<Room> searchAvailableRooms(Date checkInDate, Date checkOutDate, int numberOfGuests);
	
	 Room addRoom(Room room);
	 Room updateRoom(String id, Room room) ;
	    
	    List<Room> getAllRoom();
	

}
