package com.tal.employeemanager.service.employee;

import com.tal.employeemanager.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity insert(EmployeeEntity employeeEntity);

    List<EmployeeEntity> findAll();

    EmployeeEntity find(Long id);

    EmployeeEntity update(EmployeeEntity employeeEntity);

    void delete(Long id);
}
