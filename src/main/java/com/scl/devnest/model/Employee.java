package com.scl.devnest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private String employeeNumber;
	private String firstName;
	private String lastName;
	private String department;
	private String designation;
}
