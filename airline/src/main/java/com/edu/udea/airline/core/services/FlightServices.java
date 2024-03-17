package com.edu.udea.airline.core.services;
import com.edu.udea.airline.domain.AirplaneModel;
import com.edu.udea.airline.domain.Airport;
import com.edu.udea.airline.domain.Flight;
import com.edu.udea.airline.domain.Scale;
import com.edu.udea.airline.domain.model.FlightDTO;
import com.edu.udea.airline.domain.model.ScaleDTO;
import com.edu.udea.airline.repository.IAirplaneRepository;
import com.edu.udea.airline.repository.IAirportRespository;
import com.edu.udea.airline.repository.IFlightsRepository;
import com.edu.udea.airline.repository.IScaleRespository;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class FlightServices {


    @Autowired
    private IFlightsRepository flightRepository;

    @Autowired
    private ScaleServices scaleServices;

    @Autowired
    private ModelMapper modelMapper;
    public List<Flight> searchFlights() {
        return flightRepository.findAll();
    }


    public Flight addFlight(Flight flight) {
        Flight savedFlight = null;
        try {
            savedFlight = flightRepository.save(flight);;

            Set<Scale> scales = flight.getScales();
            if (scales != null && !scales.isEmpty()) {
                for (Scale scale : scales) {
                    scale.setFlight(savedFlight);
                    scale = scaleServices.saveScale(scale);
                }
                savedFlight.setScales(scales);
            }

        } catch (Exception e) {
            System.out.println("Error al guardar el vuelo: " + e);
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
        return flight != null ? Collections.singletonList(flight) : Collections.<Flight>emptyList();
    }
    public Flight updateFlight(Flight flight) {
        Long flightId = flight.getId();
        if (flightId == null || !flightRepository.existsById(flightId)) {
            throw new RuntimeException("El vuelo a actualizar no existe");
        }
        return flightRepository.save(modelMapper.map(flight, Flight.class));
    }

}
