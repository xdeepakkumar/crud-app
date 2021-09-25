package com.crudapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crudapp.models.Employee;

@Service
public interface EmployeeService {
	
	//get all employee
	public List<Employee> getAllEmployee();
	
	//add employee
	public void addEmployee(Employee employee);
	
	//get employee by id
	public Employee getEmployeeById(Long id);
	
	//delete employee
	public void deleteEmployee(Long id);
	
}
