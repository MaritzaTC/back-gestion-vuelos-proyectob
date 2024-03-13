package com.edu.udea.airline.repository;

import com.edu.udea.airline.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightsRepository extends JpaRepository<Flight, Long> {
}
