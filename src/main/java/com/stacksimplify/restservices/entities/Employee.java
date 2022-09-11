package com.stacksimplify.restservices.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Employee {
	@JsonView(EmployeeViews.Normal.class)
	@Id
	Long id;
	@JsonView(EmployeeViews.Normal.class)
	String name;
	@JsonView(EmployeeViews.Normal.class)
	String department;
	@JsonView(EmployeeViews.Manager.class)
	Date loginTime;
	@JsonView(EmployeeViews.Manager.class)
	Date logoutTime;
	@JsonView(EmployeeViews.HR.class)
	Long salary;
	@JsonView(EmployeeViews.HR.class)
	Date lastPromotionDate;
	Employee(){}
	public Employee(Long i, String name, String department, Date loginTime, Date logoutTime, int j,
			Date lastPromotionDate) {
		super();
		this.id = i;
		this.name = name;
		this.department = department;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.salary = (long) j;
		this.lastPromotionDate = lastPromotionDate;
	}
		
}
