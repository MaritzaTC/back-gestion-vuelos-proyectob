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

@Service
public class ScaleServices {

    @Autowired
    private IScaleRespository scaleRepository;

    @Autowired
    private IAirplaneRepository airplaneRepository;

    @Autowired
    private IAirportRespository airportRespository;

    /**
     * Saves a scale.
     * 
     * @param scale The scale to be saved.
     * @return The saved scale.
     */
    public Scale saveScale(Scale scale) {
        Airport originAirport = airportRespository.findById(scale.getOriginAirport().getId()).get();
        Airport destinationAirport = airportRespository.findById(scale.getDestinationAirport().getId()).get();
        AirplaneModel airplaneModel = airplaneRepository.findById(scale.getAirplaneModel().getId()).get();
        scale.setOriginAirport(originAirport);
        scale.setDestinationAirport(destinationAirport);
        scale.setAirplaneModel(airplaneModel);
        return scaleRepository.save(scale);
    }
}
