package com.edu.udea.airline.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Represents a flight in the airline system.
 */
@Data
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "flight", schema = "Code_factory")
public class Flight {
    @Id
    @Column(name = "flight_number", nullable = false,unique = true, updatable = true, length = 8)
    private String flightNumber;

    @NotNull
    @Column(name = "base_price", nullable = false)
    private double basePrice;

    @NotNull
    @Column(name = "tax_percent", nullable = false)
    private double taxPercentage;

    @NotNull
    @Column(name = "surcharge", nullable = false)
    private double surcharge;

    @OneToMany(mappedBy = "flight")
    private Set<Scale> scales = new HashSet<Scale>();

    @Column(name = "flight_type")
    private String typeFlight;

}
