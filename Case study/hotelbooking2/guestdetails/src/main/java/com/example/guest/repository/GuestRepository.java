package com.example.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.guest.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {


	

}
