package com.tal.employeemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Guide: https://www.youtube.com/watch?v=Gx4iBLKLVHk&t=757s
 */
@PropertySource(value = {"/application.properties", "/record.properties"})
@SpringBootApplication public class EmployeeManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagerApplication.class, args);
    }

}
