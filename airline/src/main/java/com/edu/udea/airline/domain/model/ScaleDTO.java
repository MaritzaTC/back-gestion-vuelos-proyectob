package com.edu.udea.airline.domain.model;

import com.edu.udea.airline.domain.AirplaneModel;
import com.edu.udea.airline.domain.Airport;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Setter
@Getter
@ToString
public class ScaleDTO {
    private Long scaleId;
    private AirplaneModel airplaneModel;
    private Airport originAirport;
    private Airport destinationAirport;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDate;
}
