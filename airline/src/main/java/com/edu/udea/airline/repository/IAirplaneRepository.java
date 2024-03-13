package com.edu.udea.airline.repository;

import com.edu.udea.airline.domain.AirplaneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirplaneRepository extends JpaRepository<AirplaneModel, Long> {
}
