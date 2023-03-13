package com.springboot.rest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.backend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
