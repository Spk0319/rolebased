package com.example.demo.controller;

import com.example.demo.model.HostelDetails;
import com.example.demo.service.HostelDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hosteldetails")
public class HostelDetailsController {

    @Autowired
    private HostelDetailsService hostelDetailsService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    @PostMapping
    public ResponseEntity<HostelDetails> createHostel(@RequestBody HostelDetails hostelDetails) {
        HostelDetails createdHostel = hostelDetailsService.saveHostelDetails(hostelDetails);
        return ResponseEntity.ok(createdHostel);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<HostelDetails> updateHostel(@PathVariable Long id, @RequestBody HostelDetails hostelDetails) {
        Optional<HostelDetails> updatedHostel = hostelDetailsService.updateHostelDetails(id, hostelDetails);
        return updatedHostel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHostel(@PathVariable Long id) {
        hostelDetailsService.deleteHostelDetails(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    @GetMapping
    public ResponseEntity<List<HostelDetails>> getAllHostels() {
        List<HostelDetails> hostels = hostelDetailsService.getAllHostelDetails();
        return ResponseEntity.ok(hostels);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    @GetMapping("/{id}")
    public ResponseEntity<HostelDetails> getHostelById(@PathVariable Long id) {
        Optional<HostelDetails> hostel = hostelDetailsService.getHostelDetailsById(id);
        return hostel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
