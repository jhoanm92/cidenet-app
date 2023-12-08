package com.cidenet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeDTO {

    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private String extraName;

    @NotNull
    private CountryDTO country;

    @NotNull
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationDate;
}
