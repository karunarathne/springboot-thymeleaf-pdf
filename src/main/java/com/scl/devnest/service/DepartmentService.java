package com.scl.devnest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scl.devnest.model.Department;

@Service
public class DepartmentService {

	private static List<Department> departments;
	
	static {
		departments = new ArrayList<>();
		
		departments.add(new Department("Finance", 10));
		departments.add(new Department("Accounts", 12));
	}
	
	@SuppressWarnings("static-access")
	public List<Department> getDepartmentList() {
		return this.departments;
	}
}
