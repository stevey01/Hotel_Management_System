package com.example.staff.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {

	

}

