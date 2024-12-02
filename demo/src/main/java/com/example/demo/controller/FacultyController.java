package com.example.demo.controller;

import com.example.demo.model.Faculty;
import com.example.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // Create a new Faculty - Only accessible by Admin
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.createFaculty(faculty);
        return new ResponseEntity<>(createdFaculty, HttpStatus.CREATED);
    }

    // Get all Faculties - Accessible by Admin
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> faculties = facultyService.getAllFaculties();
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }

    // Get Faculty by ID - Accessible by Admin, Faculty, and Student
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'FACULTY', 'STUDENT')")
    public ResponseEntity<Optional<Faculty>> getFacultyById(@PathVariable Long id) {
        Optional<Faculty> faculty = facultyService.getFacultyById(id);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('FACULTY')")
    @GetMapping("/email")
    public Optional<Faculty> getFacultyByEmail(@RequestParam String email) {
        return facultyService.getFacultyByEmail(email);
    }

    // Update Faculty by ID - Accessible by Admin and the Faculty themselves
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'FACULTY')")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty facultyDetails) {
        Faculty updatedFaculty = facultyService.updateFaculty(id, facultyDetails);
        return new ResponseEntity<>(updatedFaculty, HttpStatus.OK);
    }

    // Delete Faculty by ID - Only accessible by Admin
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
