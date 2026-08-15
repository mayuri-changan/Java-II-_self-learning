package com.demo.controller;

import java.util.ArrayList;
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

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final List<Employee> employees = new ArrayList<>();

	public EmployeeController() {
		// Sample data
		employees.add(new Employee(1L, "kg", "Developer", 50000));
		employees.add(new Employee(2L, "gk", "Tester", 40000));
	}

	// GET /api/employees
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employees;
	}

	// GET /api/employees/{id}
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return employees.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElse(null);
	}

	// POST /api/employees
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId((long) (employees.size() + 1));
		employees.add(employee);
		return employee;
	}

	// PUT /api/employees/{id}
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updated) {
		for (Employee emp : employees) {
			if (emp.getId().equals(id)) {
				emp.setName(updated.getName());
				emp.setRole(updated.getRole());
				emp.setSalary(updated.getSalary());
				return emp;
			}
		}
		return null;
	}

	// DELETE /api/employees/{id}
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employees.removeIf(emp -> emp.getId().equals(id));
	}
}
