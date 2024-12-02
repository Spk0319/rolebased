package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registerNumber;
    private String course;
    private String department;
    private int year;
    private String section;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and setters
    // ...
}