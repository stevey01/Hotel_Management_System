package com.example.guest.Service;

import java.util.List;




import com.example.guest.model.Guest;

public interface GuestService {
	List<Guest> getallguest();
	Guest createguest( Guest guest);
	Guest updateguest( Long id, Guest guestdetails);
    Guest getguestbyid(Long id);
	void deleteguest(Long id);
}
