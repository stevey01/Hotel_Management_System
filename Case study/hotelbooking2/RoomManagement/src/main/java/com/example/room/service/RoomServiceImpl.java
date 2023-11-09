package com.example.room.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.room.model.Room;
import com.example.room.exception.NoRoomsAvailableException;
import com.example.room.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<Room> searchAvailableRooms(Date checkInDate, Date checkOutDate, int numberOfGuests) {
		
		return roomRepository.findAvailableRooms(checkInDate, checkOutDate , numberOfGuests);
	}

	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		Room r = roomRepository.save(room);
		return r;
	}

	@Override
	public Room updateRoom(String id, Room room) {
		// TODO Auto-generated method stub
		
		Room update = roomRepository.findById(id)
				.orElseThrow(()-> new NoRoomsAvailableException("No room available with this " +id));
		
		update.setNumberOfGuests(room.getNumberOfGuests());
		update.setPrice(room.getPrice());
		update.setRoomNumber(room.getRoomNumber());
		update.setCheckInDate(room.getCheckInDate());
		update.setCheckOutDate(room.getCheckOutDate());
		return roomRepository.save(update);
	}

	@Override
	public List<Room> getAllRoom() {
		// TODO Auto-generated method stub
		List<Room> l=roomRepository.findAll();
		return l;
	}

}
