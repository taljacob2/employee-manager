package com.tal.employeemanager.controller;

import com.tal.employeemanager.entity.EmployeeEntity;
import com.tal.employeemanager.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller @RequestMapping("employee") public class EmployeeController {

    @Autowired EmployeeService employeeService;

    @GetMapping("all")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeService.findAll();
        return new ResponseEntity<>(employeeEntities, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeesById(
            @PathVariable("id") Long id) {
        EmployeeEntity employeeEntities = employeeService.find(id);
        return new ResponseEntity<>(employeeEntities, HttpStatus.OK);
    }

    @PostMapping("insert") public ResponseEntity<EmployeeEntity> insertEmployee(
            @RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity employeeEntityResponse =
                employeeService.insert(employeeEntity);
        return new ResponseEntity<>(employeeEntityResponse, HttpStatus.CREATED);
    }

    @PutMapping("update") public ResponseEntity<EmployeeEntity> updateEmployee(
            @RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity employeeEntityResponse =
                employeeService.update(employeeEntity);
        return new ResponseEntity<>(employeeEntityResponse, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
