package com.tal.employeemanager.repository;

import com.tal.employeemanager.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<EmployeeEntity, Long> {}
