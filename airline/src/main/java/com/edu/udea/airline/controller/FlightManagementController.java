package com.edu.udea.airline.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.edu.udea.airline.core.services.FlightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.udea.airline.domain.Flight;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightManagementController {

    @Autowired
    private FlightServices flightService;

    @GetMapping("/search")
    public List<Flight> searchFlights() {
        return flightService.searchFlights();
    }
    /**
     *
     * @param flight
     * @return
     */
    @PostMapping("/add")
    public Flight addFlight(@RequestBody Flight flight){
        return flightService.addFlight(flight);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
    }

    @GetMapping("/search/{id}")
    public List<Flight> searchFlight(@PathVariable Long id){
        return flightService.searchFlight(id);
    }

    @PutMapping("/update")
    public Flight updateFlight(@RequestBody Flight flight){
        return  flightService.updateFlight(flight);
    }
}
