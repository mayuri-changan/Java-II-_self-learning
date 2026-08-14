package com.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeClientController {

	private final RestTemplate restTemplate = new RestTemplate();

	// GET all employees
	@GetMapping
	public List<Employee> getEmployees() {
		Employee[] employees = restTemplate.getForObject("http://localhost:8080/api/employees", Employee[].class);
		return Arrays.asList(employees);
	}

	// GET one employee
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return restTemplate.getForObject("http://localhost:8080/api/employees/" + id, Employee.class);
	}

	// POST new employee
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return restTemplate.postForObject("http://localhost:8080/api/employees", employee, Employee.class);
	}

	// PUT update employee
	@PutMapping("/{id}")
	public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		restTemplate.put("http://localhost:8080/api/employees/" + id, employee);
	}

	// DELETE employee
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		restTemplate.delete("http://localhost:8080/api/employees/" + id);
	}
}
