package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT')")
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT')")
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT')")
    @GetMapping("/email")
    public Optional<Student> getStudentByEmail(@RequestParam String email) {
        return studentService.getStudentByEmail(email);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT')")
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
