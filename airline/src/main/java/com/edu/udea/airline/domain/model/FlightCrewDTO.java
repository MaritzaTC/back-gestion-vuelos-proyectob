package com.edu.udea.airline.domain.model;

import com.edu.udea.airline.domain.Employee;
import com.edu.udea.airline.domain.Flight;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FlightCrewDTO {
    private Long id;
    private Flight flight;
    private Employee employee;
    private String flightRole;

}
