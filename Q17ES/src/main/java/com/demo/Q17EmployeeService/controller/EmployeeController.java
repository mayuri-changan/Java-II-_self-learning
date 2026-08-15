package com.demo.Q17EmployeeService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public String getEmployees() {
        return "List of Employees from Employee Service";
    }
}
