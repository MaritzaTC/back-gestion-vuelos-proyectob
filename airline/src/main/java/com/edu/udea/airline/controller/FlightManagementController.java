package com.edu.udea.airline.controller;

import com.edu.udea.airline.domain.Scale;
import com.edu.udea.airline.domain.model.FlightDTO;
import com.edu.udea.airline.domain.model.ScaleDTO;
import com.edu.udea.airline.core.services.FlightServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.udea.airline.domain.Flight;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightManagementController {

    @Autowired
    private FlightServices flightService;

    @Autowired
    private ModelMapper modelMapper;

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
    public FlightDTO addFlight(@RequestBody FlightDTO flight) {
        Flight transformedFlight = modelMapper.map(flight, Flight.class);

        Flight savedFlight = flightService.addFlight(transformedFlight);

        return modelMapper.map(savedFlight, FlightDTO.class);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }

    @GetMapping("/search/{id}")
    public List<Flight> searchFlight(@PathVariable Long id) {
        return flightService.searchFlight(id);
    }

    @PutMapping("/update")
    public Flight updateFlight(@RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }
}
