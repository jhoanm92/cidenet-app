package com.cidenet.controller;

import com.cidenet.dto.CountryDTO;
import com.cidenet.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping()
    public ResponseEntity<List<CountryDTO>> getAll() throws Exception {
        return new ResponseEntity<List<CountryDTO>>(service.getAll(), HttpStatus.OK);
    }
}
