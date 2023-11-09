package com.example.room.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.room.model.Room;
import com.example.room.exception.NoRoomsAvailableException;
import com.example.room.service.RoomService;



@RestController
@RequestMapping("/rooms")
public class RoomController {
	
    @Autowired
    private RoomService roomService;

    @GetMapping("/get")
    public List<Room> searchRooms(
            @RequestParam String checkInDate,
            @RequestParam String checkOutDate,
            @RequestParam int numberOfGuests) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date checkIn = dateFormat.parse(checkInDate);
        Date checkOut = dateFormat.parse(checkOutDate);

        List<Room> availableRooms = roomService.searchAvailableRooms(checkIn, checkOut, numberOfGuests);
        if (availableRooms.isEmpty()) {
            throw new NoRoomsAvailableException("No rooms available for the selected dates and number of guests.");
        }
        return availableRooms;
    }
    
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Room> createUser(@RequestBody Room room) throws Exception {
    	Room g = roomService.addRoom(room);
        return new ResponseEntity<Room>(g, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRoom(@PathVariable String id, @RequestBody Room room) throws NoRoomsAvailableException {
        roomService.updateRoom(id, room);
        return ResponseEntity.ok( "Room updated successfully.");
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Room>> getAllRoom(){
        return new ResponseEntity<List<Room>>( roomService.getAllRoom(),HttpStatus.OK);
    }

}
