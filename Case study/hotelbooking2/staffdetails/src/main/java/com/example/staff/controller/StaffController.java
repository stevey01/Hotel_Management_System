package com.example.staff.controller;

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

import com.example.staff.Service.StaffService;

import com.example.staff.exception.ResourceNotFoundException;
import com.example.staff.model.Staff;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/hms/v2/")
@CrossOrigin(origins="http://localhost:4200/")
public class StaffController {

	@Autowired
	StaffService staffservice;
	@GetMapping("/staff")
	
	public List<Staff> getAllstaff()
	{
		log.info("Inside the getAllStaff() method of controller");
		 log.info("Retrieving AllStaff Data ");
	return staffservice.getAllStaffs();
	}
	
	
	@PostMapping("/staff")
	public ResponseEntity<Staff> createStaff(@RequestBody @Valid Staff staff)
	{
		staffservice.createStaff(staff);
		log.info("Inside the createStaff() method of controller");
		log.info("Adding Staff "+staff);
		return ResponseEntity.ok(staff);
	}
	
	@PutMapping("/staff/{id}")
	public ResponseEntity<Staff> updatestaff(@PathVariable Long id, @Valid @RequestBody Staff staffdetails)throws ResourceNotFoundException
	{
		 staffservice.updateStaff(id, staffdetails);
		 log.info("Inside the updateStaff() method of controller");
		 log.info("Updating Staff Data by id ");
		return ResponseEntity.ok(staffdetails);
		
	}
	@DeleteMapping("/staff/{id}")
	public ResponseEntity<Map<String, Boolean>> deletestaff(@PathVariable Long id) {
		staffservice.deleteStaff(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		log.info("Inside the deleteStaff() method of controller");
		 log.info("Deleting A Staff successfully ");
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/staff/{id}")
	public ResponseEntity<Staff>  getstaffbyid(@PathVariable Long id)
	{
		 Staff staff = staffservice.getstaffbyid(id);
		 log.info("Inside the getStaffbyid() method of controller");
		 log.info("Retrieving Staff Details by Id ");
	        return ResponseEntity.ok(staff);
	}
}
