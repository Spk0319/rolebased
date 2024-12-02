package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByEmail(String email); // Custom method to find bookings by email
}
