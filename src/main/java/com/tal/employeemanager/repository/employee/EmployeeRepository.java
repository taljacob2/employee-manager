package com.tal.employeemanager.repository.employee;

import com.tal.employeemanager.entity.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<EmployeeEntity, Long> {
    // List<EmployeeEntity> findByRecordשם_ישוב(String שם_ישוב);
}
