package com.example.demo.controller;

import com.example.demo.model.Hall;
import com.example.demo.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('FACULTY') or hasAuthority('STUDENT')")
    public List<Hall> getAllHalls() {
        return hallService.getAllHalls();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('FACULTY') or hasAuthority('STUDENT')")
    public Hall getHallById(@PathVariable Long id) {
        return hallService.getHallById(id).orElseThrow(() -> new RuntimeException("Hall not found"));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Hall createHall(@RequestBody Hall hall) {
        return hallService.createHall(hall);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Hall updateHall(@PathVariable Long id, @RequestBody Hall hallDetails) {
        return hallService.updateHall(id, hallDetails);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteHall(@PathVariable Long id) {
        hallService.deleteHall(id);
    }
}
