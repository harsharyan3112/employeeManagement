package com.springboot.rest.backend.service;

import java.util.List;

import com.springboot.rest.backend.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployee(long id);
	Employee updateEmployee(Employee employee,long id);
	void deletEmployee(long id);
}
