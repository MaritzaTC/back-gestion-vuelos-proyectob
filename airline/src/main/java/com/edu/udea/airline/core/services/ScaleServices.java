package com.edu.udea.airline.core.services;

import com.edu.udea.airline.domain.AirplaneModel;
import com.edu.udea.airline.domain.Airport;
import com.edu.udea.airline.domain.Flight;
import com.edu.udea.airline.domain.Scale;
import com.edu.udea.airline.repository.IAirplaneRepository;
import com.edu.udea.airline.repository.IAirportRespository;
import com.edu.udea.airline.repository.IScaleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScaleServices {

    @Autowired
    private IScaleRespository scaleRepository;

    @Autowired
    private IAirplaneRepository airplaneRepository;

    @Autowired
    private IAirportRespository airportRespository;

    /**
     * Saves a scale after validating the origin and destination airports, departure and arrival times.
     *
     * @param scale The scale to be saved.
     * @return The saved scale.
     */
    public Scale saveScale(Scale scale) {
        validateOriginAndDestination(scale);
        validateTimes(scale);

        Airport originAirport = airportRespository.findById(scale.getOriginAirport().getId()).orElse(null);
        Airport destinationAirport = airportRespository.findById(scale.getDestinationAirport().getId()).orElse(null);
        AirplaneModel airplaneModel = airplaneRepository.findById(scale.getAirplaneModel().getId()).orElse(null);

        if (originAirport == null || destinationAirport == null || airplaneModel == null) {
            throw new IllegalArgumentException("Debe ingresar los campos de origen, destino y modelo de avión.");
        }
        scale.setOriginAirport(originAirport);
        scale.setDestinationAirport(destinationAirport);
        scale.setAirplaneModel(airplaneModel);

        return scaleRepository.save(scale);
    }

    private void validateOriginAndDestination(Scale scale) {
        if (scale.getOriginAirport().equals(scale.getDestinationAirport())) {
            throw new IllegalArgumentException("La ciudad de origen y destino no pueden ser la misma.");
        }
    }

    private void validateTimes(Scale scale) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime departureTime = scale.getDepartureDate();
        LocalDateTime arrivalTime = scale.getArrivalDate();

        if (departureTime == null || arrivalTime == null) {
            throw new IllegalArgumentException("Las horas de salida y llegada son obligatorias.");
        }

        if (departureTime.isBefore(now.plusHours(1))) {
            throw new IllegalArgumentException("La hora de salida debe ser al menos una hora después de la hora actual.");
        }

        if (arrivalTime.isBefore(departureTime)) {
            throw new IllegalArgumentException("La hora de llegada debe ser posterior a la hora de salida.");
        }
    }
}
