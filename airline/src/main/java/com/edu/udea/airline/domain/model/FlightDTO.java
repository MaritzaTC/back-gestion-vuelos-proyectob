package com.edu.udea.airline.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FlightDTO {
    private Long id;
    private String flightNumber;
    private double basePrice;
    private double taxPercentage;
    private double surcharge;

    public FlightDTO() {
    }

    public FlightDTO(Long id, String flightNumber, double basePrice, double taxPercentage, double surcharge) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.basePrice = basePrice;
        this.taxPercentage = taxPercentage;
        this.surcharge = surcharge;
    }

}
