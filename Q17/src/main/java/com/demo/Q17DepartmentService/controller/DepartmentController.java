package com.demo.Q17DepartmentService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

	@GetMapping("/departments")
	public String getDepartments() {
		return "List of Departments from Department Service";
	}
}
