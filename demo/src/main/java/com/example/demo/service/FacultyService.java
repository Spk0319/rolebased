package com.example.demo.service;

import com.example.demo.model.Faculty;
import com.example.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.findById(id);
    }
    public Optional<Faculty> getFacultyByEmail(String email) {
        return facultyRepository.findByUserEmail(email);
    }

    public Faculty updateFaculty(Long id, Faculty facultyDetails) {
        Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new RuntimeException("Faculty not found"));
        faculty.setDepartment(facultyDetails.getDepartment());
        faculty.setDesignation(facultyDetails.getDesignation());
        faculty.setExpertise(facultyDetails.getExpertise());
        faculty.setUser(facultyDetails.getUser());
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new RuntimeException("Faculty not found"));
        facultyRepository.delete(faculty);
    }
}
