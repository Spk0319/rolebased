package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dateOfBirth;
    private String gender;
    private String email;
    private String password;
    private String role;

    // Getters and setters
    // ...
}