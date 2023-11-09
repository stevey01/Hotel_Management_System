package com.example.staff;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.example.staff.Service.StaffService;

import com.example.staff.model.Staff;
import com.example.staff.repository.StaffRepository;

@SpringBootTest
class StaffdetailsApplicationTests {

	

	@Autowired
	StaffService staffservice;
	
	@MockBean
	StaffRepository staffRepository;
	

	
	@Test
	void contextLoads() {
		
	}
	@Test
	public void getallstaff()
	{
		when(staffRepository.findAll()).thenReturn(Stream.of(new Staff((long) 1,"sam","madurai",1000,"chef","sam@gmail.com")).collect(Collectors.toList()));
	
	assertEquals(1,staffservice.getAllStaffs().size());
	}
	@Test
public void savestaff()
{
	Staff staff=new Staff((long) 1,"sam","madurai",1000,"chef","sam@gmail.com");
	when(staffRepository.save(staff)).thenReturn(staff);
	
	assertEquals(staff,staffservice.createStaff(staff));
}
	@Test
	public void deletestaff()
	{
	     Long id = 1L;
	     Staff staff=new Staff((long) 1,"sam","madurai",1000,"chef","sam@gmail.com");
	        staff.setId(id);

	        when(staffRepository.findById(id)).thenReturn(Optional.of(staff));

	        staffservice.deleteStaff(id);


	        verify(staffRepository,times(1)).delete(staff);
	}
	   @Test
	    void updateStaff() {
		   Staff staff= new Staff((long) 1,"sam","madurai",1000,"chef","sam@gmail.com");
	        Long id = 1L;
             
	        Staff existingStaff=new Staff();
	        when(staffRepository.findById(id)).thenReturn(Optional.of(existingStaff));
	        when(staffRepository.save(existingStaff)).thenReturn(existingStaff);

	     
	        Staff updatedStaff = staffservice.updateStaff(id, staff);

	      
	        assertEquals(staff.getAddress(), updatedStaff.getAddress());
	        assertEquals(staff.getEmail(), updatedStaff.getEmail());
	      
	        
	    }
	   
	   @Test
	    public void testStaffById() {
	       
		   Staff sampleStaff= new Staff((long) 1,"sam","madurai",1000,"chef","sam@gmail.com");
	        Long id = 1L;

	        sampleStaff.setId(id);
	       
	        when(staffRepository.findById(id)).thenReturn(Optional.of(sampleStaff));
	      
	        Staff retrievedStaff = staffservice.getstaffbyid(id);
	       
	        assertEquals(sampleStaff.getId(), retrievedStaff.getId());
	       
	    }

	  






	   
	
}