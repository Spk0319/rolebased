package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }
    public List<Booking> getBookingsByEmail(String email) {
        return bookingRepository.findByEmail(email); // Utilize the custom query method
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setEmail(bookingDetails.getEmail());
        booking.setName(bookingDetails.getName());
        booking.setYear(bookingDetails.getYear());
        booking.setDept(bookingDetails.getDept());
        booking.setSec(bookingDetails.getSec());
        booking.setEventName(bookingDetails.getEventName());
        booking.setEventDetails(bookingDetails.getEventDetails());
        booking.setEventDate(bookingDetails.getEventDate());
        booking.setNumberOfAttendees(bookingDetails.getNumberOfAttendees());
        booking.setStartTime(bookingDetails.getStartTime());
        booking.setEndTime(bookingDetails.getEndTime());
        booking.setAdditionalRequest(bookingDetails.getAdditionalRequest());
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
        bookingRepository.delete(booking);
    }
}