package com.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private final EmployeeRepository repo;

	public EmployeeController(EmployeeRepository repo) {
		this.repo = repo;
	}

	// GET http://localhost:8080/api/employees
	@GetMapping
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	// GET http://localhost:8080/api/employees/1
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	}

	//POST http://localhost:8080/api/employees
	//{ "name": "dev", "role": "Developer", "salary": 50000 }
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return repo.save(employee);
	}
	
	//PUT http://localhost:8080/api/employees/1
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return repo.save(employee);
	}

	//DELETE http://localhost:8080/api/employees/1
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		repo.deleteById(id);
		return "Employee deleted successfully";
	}
}
