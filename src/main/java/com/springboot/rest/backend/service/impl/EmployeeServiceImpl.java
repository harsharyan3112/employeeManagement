package com.springboot.rest.backend.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.springboot.rest.backend.exception.ResourceNotFoundException;
import com.springboot.rest.backend.model.Employee;
import com.springboot.rest.backend.repository.EmployeeRepository;
import com.springboot.rest.backend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(long id) {
//		Optional<Employee> employee= employeeRepository.findById(id);
//		if(employee.isPresent())
//		{
//			return employee.get();
//		}
//		else {
//			throw new ResourceNotFoundException("Employee","Id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(()->
			new ResourceNotFoundException("Employee","Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save all the data
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}

	@Override
	public void deletEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

}