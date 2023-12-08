package com.cidenet.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class CountryDTO {

    private Integer id;
    @NotNull
    private String nameCountry;
}
