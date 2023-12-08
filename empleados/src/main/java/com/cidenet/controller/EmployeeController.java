package com.cidenet.controller;

import com.cidenet.dto.EmployeeDTO;
import com.cidenet.exception.ModeloNotFoundException;
import com.cidenet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping()
    public ResponseEntity<EmployeeDTO> registrar(@RequestBody EmployeeDTO obj) throws Exception {
        return new ResponseEntity<EmployeeDTO>(service.register(obj), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getAll() throws Exception {
        return new ResponseEntity<List<EmployeeDTO>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<EmployeeDTO>> getAll(Pageable pageable) throws Exception {
        return new ResponseEntity<Page<EmployeeDTO>>(service.getAll(pageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        EmployeeDTO obj = service.getById(id);
        if (obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
