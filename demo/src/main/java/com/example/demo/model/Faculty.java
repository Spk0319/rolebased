package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;
    private String designation;
    private String expertise;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and setters
    // ...
}