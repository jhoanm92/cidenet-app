package com.cidenet.service;

import com.cidenet.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService extends CRUD<EmployeeDTO, Integer>{

    Page<EmployeeDTO> getAll(Pageable pageable) throws Exception;

}
