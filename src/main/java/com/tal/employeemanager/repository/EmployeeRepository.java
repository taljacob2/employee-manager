package com.tal.employeemanager.repository;

import com.tal.employeemanager.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findByCityName(String cityName);
}
