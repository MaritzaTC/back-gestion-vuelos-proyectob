package com.edu.udea.airline.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AirportDTO {
    private String id;
    private String name;
    private String type;
    private String city;
    private String country;
    private double runways;
}
