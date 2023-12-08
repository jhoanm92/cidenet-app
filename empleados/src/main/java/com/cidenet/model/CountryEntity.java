package com.cidenet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "countries")
public class CountryEntity implements Serializable {

    @Id
    @Column(name = "id_country")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_country", length = 50, unique = true, nullable = false)
    private String nameCountry;

    @Column(name = "domain", length = 50, unique = true, nullable = false)
    private String domain;
}
