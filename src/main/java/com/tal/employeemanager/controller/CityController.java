package com.tal.employeemanager.controller;

import com.tal.employeemanager.entity.CityEntity;
import com.tal.employeemanager.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller @RequestMapping("city") public class CityController {

    @Autowired CityService cityService;

    @GetMapping public ResponseEntity<List<CityEntity>> getAllEmployees() {
        List<CityEntity> employeeEntities = cityService.findAll();
        return new ResponseEntity<>(employeeEntities, HttpStatus.OK);
    }

    @PostMapping public ResponseEntity<?> insertEmployee(
            @RequestBody CityEntity cityEntity) {
        try {
            CityEntity cityEntityResponse = cityService.insert(cityEntity);
            return new ResponseEntity<>(cityEntityResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
