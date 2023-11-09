package com.example.reservation.room.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.example.reservation.exception.ResourceNotFoundException;
import com.example.reservation.model.Room;

public interface RoomService {
	
	
	
	 Room addRoom(Room room);
	
	    
	    List<Room> getAllRoom();
		Room updateRoom(long id, Room room);


		Room getroombyid(Long id);


		void deleteroom(Long id);


		List<Room> searchAvailableRooms(LocalDate checkin_date, LocalDate checout_date);


	//	List<Room> searchByType(String type);


		//Room getroombycode(String code);




		

		//List<Room> searchRooms(String checkInDate, String checkOutDate) throws ResourceNotFoundException, ParseException;

	
	

}
