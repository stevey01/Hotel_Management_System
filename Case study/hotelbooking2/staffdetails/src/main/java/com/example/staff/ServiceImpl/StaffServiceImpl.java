package com.example.staff.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.staff.Service.StaffService;

import com.example.staff.exception.ResourceNotFoundException;
import com.example.staff.model.Staff;
import com.example.staff.repository.StaffRepository;
@Service
public class StaffServiceImpl implements StaffService {

	
	
	 
	 @Autowired
	StaffRepository staffrepository;
	@Override
	public List<Staff> getAllStaffs() {
		// TODO Auto-generated method stub
		return staffrepository.findAll();	}
	

	@Override
	public Staff createStaff(Staff staffs) {
		// TODO Auto-generated method stub
	//	  Staff staff = new Staff();
	  //      BeanUtils.copyProperties(staffdto, staff);
	        Staff staff= staffrepository.save( staffs);
	        return staff;
	}

	@Override
	public Staff updateStaff(Long id, Staff staffdetails) {
		// TODO Auto-generated method stub

		Staff staff=staffrepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Staff not exist with id :" + id));
	
	     staff.setName(staffdetails.getName());
	     staff.setAddress(staffdetails.getAddress());
	     staff.setSalary(staffdetails.getSalary());
	     staff.setOccupation(staffdetails.getOccupation());
	     staff.setEmail(staffdetails.getEmail());
		
		
	

		Staff staffs= staffrepository.save(staff);
		return staffs;
		
	}

	@Override
	public void deleteStaff(Long id) {
		// TODO Auto-generated method stub
		Staff staff = staffrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Staff not exist with id :" + id));

		staffrepository.delete(staff);
	}
	@Override
	public Staff getstaffbyid(Long id) {
		return staffrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
		
	}

	
}
