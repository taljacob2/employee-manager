package com.tal.employeemanager.controller;

import com.tal.employeemanager.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("city") public class CityController {


    @Autowired CityService cityService;
}
