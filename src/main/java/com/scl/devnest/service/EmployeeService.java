package com.scl.devnest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scl.devnest.model.Employee;

@Service
public class EmployeeService {
	
	private static List<Employee> employeeList;
	
	static {
		employeeList = new ArrayList<>();
		
		employeeList.add(new Employee("1", "SB", "Karunarathne", "Finance", "Manager"));
		employeeList.add(new Employee("2", "PG", "Kumudumali", "Accounts", "Accountant"));
	}

	@SuppressWarnings("static-access")
	public List<Employee> getEmployeeList() {
		return this.employeeList;
	}
}
