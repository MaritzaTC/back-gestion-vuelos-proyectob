package com.edu.udea.airline.repository;

import com.edu.udea.airline.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirportRespository extends JpaRepository<Airport, Long> {

}
