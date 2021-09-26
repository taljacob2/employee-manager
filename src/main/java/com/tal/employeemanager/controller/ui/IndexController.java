package com.tal.employeemanager.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/") public class IndexController {

    @GetMapping private String index() {
        return "dist/employee-manager/index.html";
    }

}
