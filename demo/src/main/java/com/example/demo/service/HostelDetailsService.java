package com.example.demo.service;

import com.example.demo.model.HostelDetails;
import com.example.demo.repository.HostelDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostelDetailsService {

    @Autowired
    private HostelDetailsRepository hostelDetailsRepository;

    public HostelDetails saveHostelDetails(HostelDetails hostelDetails) {
        return hostelDetailsRepository.save(hostelDetails);
    }

    public Optional<HostelDetails> updateHostelDetails(Long id, HostelDetails hostelDetails) {
        return hostelDetailsRepository.findById(id).map(existingHostel -> {
            existingHostel.setName(hostelDetails.getName());
            existingHostel.setDescription(hostelDetails.getDescription());
            existingHostel.setCapacity(hostelDetails.getCapacity());
            existingHostel.setLocation(hostelDetails.getLocation());
            existingHostel.setImageUrl(hostelDetails.getImageUrl());
            return hostelDetailsRepository.save(existingHostel);
        });
    }

    public void deleteHostelDetails(Long id) {
        hostelDetailsRepository.deleteById(id);
    }

    public List<HostelDetails> getAllHostelDetails() {
        return hostelDetailsRepository.findAll();
    }

    public Optional<HostelDetails> getHostelDetailsById(Long id) {
        return hostelDetailsRepository.findById(id);
    }
}
