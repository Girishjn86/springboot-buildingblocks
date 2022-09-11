package com.stacksimplify.restservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.stacksimplify.restservices.entities.Employee;
import com.stacksimplify.restservices.entities.EmployeeViews;
import com.stacksimplify.restservices.services.EmployeeService;

@RestController
@RequestMapping("/jsonview/emp")
public class EmployeeJsonViewController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/normal")
	@JsonView(EmployeeViews.Normal.class)
	public List<Employee> getEmployeeData() {
		return employeeService.getAllEmployee();
		
	}
	@GetMapping("/manager")
	@JsonView(EmployeeViews.Manager.class)
	public List<Employee> getEmployeeData1() {
		return employeeService.getAllEmployee();		
	}
	@GetMapping("/hr")
	@JsonView(EmployeeViews.HR.class)
	public List<Employee> getEmployeeData2() {
		return employeeService.getAllEmployee();		
	}
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {		
		return employeeService.addEmployee(emp);		
	}
}
