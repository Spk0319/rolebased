package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email; // Ensure email is included
    private String name;
    private String year;
    private String dept;
    private String sec;
    private String eventName;
    private String eventDetails;
    private String eventDate;
    private String numberOfAttendees;
    private String startTime;
    private String endTime;
    private String additionalRequest;
}