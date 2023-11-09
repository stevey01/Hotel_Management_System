package com.example.reservation.ServiceImpl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.reservation.Service.ReservationService;
import com.example.reservation.exception.ResourceNotFoundException;
import com.example.reservation.model.Reservation;
import com.example.reservation.repository.Reservationrepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	Reservationrepository reservationrepository;
	 
	@Override
	public List<Reservation> getallreservations() {
		// TODO Auto-generated method stub
		return reservationrepository.findAll();
	}
	
	
	

	@Override
	public Reservation createreservation(Reservation reservation) {
		// TODO Auto-generated method stub
		//  Reservation reservation = new Reservation();
	   //     BeanUtils.copyProperties(reservationdto, reservation);
	        Reservation reservations= reservationrepository.save(reservation);
	        return reservations;
	}

	@Override
	public Reservation updatereservation(Long id, Reservation reservationdetails) {
		
		Reservation reservation=reservationrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("id not exist:" + id));
		        
				 reservation.setNo_of_Adult( reservationdetails.getNo_of_Adult());
				 reservation.setNo_of_child( reservationdetails.getNo_of_Adult());
				 reservation.setCheck_in_date( reservationdetails.getCheck_in_date());
				 reservation.setCheckout_date( reservationdetails.getCheckout_date());
				 reservation.setStatus( reservationdetails.getStatus());
				 reservation.setNumber_of_Nights( reservationdetails.getNumber_of_Nights());
				
				 Reservation reservations= reservationrepository.save(reservation);
				 
				 return reservations;

					}

	@Override
	public void deletereservation(Long id) {
		// TODO Auto-generated method 
		Reservation reservation = reservationrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id not exist :" + id));

	reservationrepository.delete(reservation);
	}
	@Override
	public Reservation getreservationbyid(Long id) {
		return reservationrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
		
	}

}
