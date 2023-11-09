package com.example.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reservation.model.Reservation;


@Repository
public interface Reservationrepository extends JpaRepository<Reservation,Long> {

}

