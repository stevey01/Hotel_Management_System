package com.example.staff.Service;

import java.util.List;


import com.example.staff.model.Staff;


public interface StaffService {
	List<Staff> getAllStaffs();
	Staff createStaff(Staff staff);
	Staff updateStaff(Long id,Staff staffdetails);
	void deleteStaff(Long id);
	Staff getstaffbyid(Long id);
	
}
