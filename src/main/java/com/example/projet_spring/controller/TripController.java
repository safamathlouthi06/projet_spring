package com.example.projet_spring.controller;

import com.example.projet_spring.model.Trip;
import com.example.projet_spring.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/{userId}")
    public String getUserTrips(@PathVariable Long userId, Model model) {
        List<Trip> trips = tripService.findByUser(userId);
        model.addAttribute("trips", trips);
        return "user-trips";
    }

    @GetMapping("/add")
    public String addTripPage(Model model) {
        model.addAttribute("trip", new Trip());
        return "add-trip";
    }

    @PostMapping("/add")
    public String addTrip(@ModelAttribute Trip trip) {
        tripService.save(trip);
        return "redirect:/trips/" + trip.getUser().getId();
    }
}
