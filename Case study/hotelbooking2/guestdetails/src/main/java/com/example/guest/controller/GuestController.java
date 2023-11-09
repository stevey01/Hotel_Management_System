package com.example.guest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.guest.ServiceImpl.GuestServiceImpl;

import com.example.guest.model.Guest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/hms/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class GuestController {

	@Autowired
	private GuestServiceImpl guestservice;
	
	@GetMapping("/guest")
	public List<Guest> getAllGuest()
	{
		log.info("Inside the GetallGuest method of Controller");
		 log.info("Retrieving AllGuest Data ");
		
	return guestservice.getallguest();
	}
	@GetMapping("/guest/{id}")
	public ResponseEntity<Guest>  getGuestById(@PathVariable Long id)
	{
		 Guest guest = guestservice.getguestbyid(id);
		 log.info("Inside the getGuestbyid() method of controller");
		 log.info("Retrieving Guest Details by Id ");
	        return ResponseEntity.ok(guest);
	}
	
	@PostMapping("/guest")
	public ResponseEntity<Guest> createGuest(@RequestBody @Valid Guest guest)
	{
		  guestservice.createguest(guest);
		  log.info("Inside the createGuest() method of controller");
			log.info("Adding Guest "+guest);
		  return ResponseEntity.ok(guest);
	}
	
	@PutMapping("/guest/{id}")
	public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @Valid @RequestBody Guest guestdetails)
	{
		
		guestservice.updateguest(id, guestdetails);
		 log.info("Inside the updateGuest() method of controller");
		 log.info("Updating Guest Data by id ");
		return ResponseEntity.ok(guestdetails);
		
	}
	@DeleteMapping("/guest/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteGuest(@PathVariable Long id) {
	guestservice.deleteguest(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		log.info("Inside the deleteGuest() method of controller");
		 log.info("Deleting A Guest successfully ");
		return ResponseEntity.ok(response);
	}

	
	
	
}
