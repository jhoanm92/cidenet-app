package com.cidenet.repository;

import com.cidenet.model.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends GenericRepository<EmployeeEntity, Integer>{


    Optional<EmployeeEntity> findByEmail(String email);

    @Query("SELECT COUNT (email) FROM EmployeeEntity emp WHERE emp.email LIKE :email%")
    Integer countEmail(String email);
}
