package com.tal.employeemanager.controller;

import com.tal.employeemanager.entity.EmployeeEntity;
import com.tal.employeemanager.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller @RequestMapping("employee") public class EmployeeController {

    @Autowired EmployeeService employeeService;

    @GetMapping public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeService.findAll();
        return new ResponseEntity<>(employeeEntities, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEmployeesById(@PathVariable("id") Long id) {
        try {
            EmployeeEntity employeeEntity = employeeService.find(id);
            return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping public ResponseEntity<EmployeeEntity> insertEmployee(
            @RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity employeeEntityResponse =
                employeeService.insert(employeeEntity);
        return new ResponseEntity<>(employeeEntityResponse, HttpStatus.CREATED);
    }

    @PutMapping public ResponseEntity<?> updateEmployee(
            @RequestBody EmployeeEntity employeeEntity) {
        try {
            EmployeeEntity employeeEntityResponse =
                    employeeService.update(employeeEntity);
            return new ResponseEntity<>(employeeEntityResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
