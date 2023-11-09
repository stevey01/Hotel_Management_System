package com.example.reservation.Service;

import java.util.List;


import com.example.reservation.model.Reservation;

public interface ReservationService {
	List<Reservation> getallreservations();
	Reservation createreservation(Reservation reservation);
	Reservation updatereservation( Long id,Reservation reservationdetails);
	void deletereservation( Long id);
	
	 Reservation getreservationbyid(Long id);
	
	
	
}
