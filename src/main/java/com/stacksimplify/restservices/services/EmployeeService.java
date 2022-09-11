package com.stacksimplify.restservices.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restservices.entities.Employee;
import com.stacksimplify.restservices.repositories.EmployeeRepository;
@Service
public class EmployeeService {
	public static Employee emp = new Employee(100L,"Harry", "Sales", new Date(),new Date(),100000,new Date());
	@Autowired
	private EmployeeRepository employeeRepository;
	public List<Employee> getAllEmployee() {
		return  employeeRepository.findAll();
	}
	
	public Employee addEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
}
