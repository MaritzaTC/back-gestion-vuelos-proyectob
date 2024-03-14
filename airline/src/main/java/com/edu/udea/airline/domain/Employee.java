package com.edu.udea.airline.domain;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Employee", schema = "Code_factory")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", updatable = false, nullable = false)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @NotNull
    @Column(name = "job_title", nullable = false, length = 30)
    private String jobTitle;
}
