package com.example.demo.service;

import com.example.demo.model.Hall;
import com.example.demo.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    public Optional<Hall> getHallById(Long id) {
        return hallRepository.findById(id);
    }

    public Hall createHall(Hall hall) {
        return hallRepository.save(hall);
    }

    public Hall updateHall(Long id, Hall hallDetails) {
        Hall hall = hallRepository.findById(id).orElseThrow(() -> new RuntimeException("Hall not found"));
        hall.setName(hallDetails.getName());
        
        hall.setCapacity(hallDetails.getCapacity());
        hall.setLocation(hallDetails.getLocation());
        hall.setImageUrl(hallDetails.getImageUrl());
        return hallRepository.save(hall);
    }

    public void deleteHall(Long id) {
        Hall hall = hallRepository.findById(id).orElseThrow(() -> new RuntimeException("Hall not found"));
        hallRepository.delete(hall);
    }
}
