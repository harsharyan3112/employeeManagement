package com.springboot.rest.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.backend.model.Employee;
import com.springboot.rest.backend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
//	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	//build create employee REST api
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	//build get all employee REST api
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	//build get employee by id
	//http://localhost:8080/api/employee/1
	@GetMapping("{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		return  employeeService.getEmployee(id);
	}
	
	//update employee
//	@PutMapping("{id}")
//	public Employee updateEmployee(@PathVariable("id")long id,@RequestBody Employee employee) {
//		return employeeService.updateEmployee(employee, id);
//	}
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")long id,@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	
	
	
	//delete employee
//	@DeleteMapping("{id}")
//	public void deleteEmployee(@PathVariable("id")long id) {
//		employeeService.deletEmployee(id);
//	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")long id) {
		employeeService.deletEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!",HttpStatus.OK);
	}
}
