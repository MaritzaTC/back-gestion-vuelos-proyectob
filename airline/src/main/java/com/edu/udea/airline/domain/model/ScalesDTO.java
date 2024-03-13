package com.edu.udea.airline.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class ScalesDTO {
    private Long id;
    /**private FlightDTO flight;
    private AirportDTO airport;" **/
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate departureDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate arrivalDate;

    public ScalesDTO() {
    }

    public ScalesDTO(Long id, LocalDate departureDate, LocalDate arrivalDate) {
        this.id = id;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

}
