package com.tal.employeemanager.repository.employee;

import com.tal.employeemanager.entity.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findBySettlementEntityName(String name);
}
