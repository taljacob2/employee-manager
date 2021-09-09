package com.tal.employeemanager.controller;

import com.tal.employeemanager.entity.CityEntity;
import com.tal.employeemanager.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("city") public class CityController {

    @Autowired CityService cityService;

    @PostMapping public ResponseEntity<CityEntity> insertEmployee(
            @RequestBody CityEntity cityEntity) {
        CityEntity cityEntityResponse = cityService.insert(cityEntity);
        return new ResponseEntity<>(cityEntityResponse, HttpStatus.CREATED);
    }
}
