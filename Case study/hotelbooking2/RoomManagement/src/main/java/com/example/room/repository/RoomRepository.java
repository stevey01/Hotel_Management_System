package com.example.room.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.room.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

	List<Room> findAvailableRooms(Date checkInDate, Date checkOutDate, int numberOfGuests);


}
