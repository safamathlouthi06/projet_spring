package com.example.projet_spring.service;

import com.example.projet_spring.model.Trip;
import com.example.projet_spring.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public List<Trip> findByUser(Long userId) {
        return tripRepository.findByUserId(userId);
    }

    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }
}
