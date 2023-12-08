package com.cidenet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "employees")
public class EmployeeEntity implements Serializable {

    @Id
    @Column(name = "id_employee")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "surname", length = 20, nullable = false)
    private String surname;

    @Column(name = "extraName", length = 50)
    private String extraName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_country_fk", referencedColumnName = "id_country")
    private CountryEntity country;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}
