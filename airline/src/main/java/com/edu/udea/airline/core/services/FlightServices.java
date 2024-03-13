package com.edu.udea.airline.core.services;
import com.edu.udea.airline.domain.Flight;
import com.edu.udea.airline.repository.IFlightsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FlightServices {


    @Autowired
    private IFlightsRepository flightRepository;

    @Autowired
    private ModelMapper modelMapper;
    public List<Flight> searchFlights() {
        return flightRepository.findAll();
    }
    /**
     * Method to add a flight
     * @param flight
     * @return
     */
    public Flight addFlight(Flight flight) {
        Flight savedFlight = null;
        try {
            savedFlight = flightRepository.save(modelMapper.map(flight, Flight.class));
        }catch (Exception e) {
            System.out.println("Error al guardar el vuelo" + e);
        }
        return savedFlight;
    }
    public void deleteFlight(Long id) {
        try {
            flightRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No se encontró el vuelo con id: " + id);
        } catch (Exception e) {
            System.out.println("Error al eliminar el vuelo con id: " + id);
        }
    }
    public List<Flight> searchFlight(Long id) {
        Flight flight = flightRepository.findById(id).orElse(null);
        return flight != null ? Collections.singletonList(flight) : Collections.emptyList();
    }
    public Flight updateFlight(Flight flight) {
        Long flightId = flight.getId();
        if (flightId == null || !flightRepository.existsById(flightId)) {
            throw new RuntimeException("El vuelo a actualizar no existe");
        }
        return flightRepository.save(modelMapper.map(flight, Flight.class));
    }

}
