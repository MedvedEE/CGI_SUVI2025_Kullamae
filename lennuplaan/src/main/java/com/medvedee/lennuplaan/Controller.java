package com.medvedee.lennuplaan;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;



@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "http://localhost:3000")
class Controller {
    private final List<Flight> flights = new ArrayList<>(List.of(
            new Flight(1, "Tallinn", "London", "2025-03-10", "10:00", 150.0),
            new Flight(2, "Tallinn", "Paris", "2025-03-12", "14:00", 200.0),
            new Flight(3, "Helsinki", "Berlin", "2025-03-15", "08:30", 180.0)
    ));
    private final Map<Integer, String> reservations = new HashMap<>();
    @GetMapping
    public List<Flight> getFlights(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String time,
            @RequestParam(required = false) Double maxPrice) {
        return flights.stream()
                .filter(f -> (destination == null || f.getDestination().equalsIgnoreCase(destination)))
                .filter(f -> (date == null || f.getDate().equals(date)))
                .filter(f -> (time == null || f.getTime().equals(time)))
                .filter(f -> (maxPrice == null || f.getPrice() <= maxPrice))
                .collect(Collectors.toList());
    }
    @PostMapping("/reserve")
    public String reserveSeat(@RequestBody Reservation reservation) {
        if (reservations.containsKey(reservation.getFlightId())) {
            return "See koht on juba broneeritud!";
        }
        reservations.put(reservation.getFlightId(), reservation.getSeat());
        return "Broneering õnnestus: lend " + reservation.getFlightId() + ", koht " + reservation.getSeat();
    }
}
