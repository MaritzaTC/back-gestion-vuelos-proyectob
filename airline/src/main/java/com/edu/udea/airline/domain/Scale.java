package com.edu.udea.airline.domain;

import com.edu.udea.airline.domain.model.AirportDTO;
import com.edu.udea.airline.domain.model.FlightDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Scale", schema = "Code_factory")
public class Scale {
      @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "scale_id", updatable = false, nullable = false)
        private Long id;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "flight_id")
        private Flight flight;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "airplane_model")
        private AirplaneModel airplaneModel;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "origin_airport")
        private Airport originAirport;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "destination_airport")
        private Airport destinationAirport;

        @JsonDeserialize(using = LocalDateDeserializer.class)
        @Column(name = "departure_date", nullable = false)
        private LocalDateTime departureDate;

        @JsonDeserialize(using = LocalDateDeserializer.class)
        @Column(name = "arrival_date", nullable = false)
        private LocalDateTime arrivalDate;

        @Column(name = "price", nullable = false)
        private double price;
}
