package com.scl.devnest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scl.devnest.model.Template;

@Service
public class TemplateService {
	
	private static List<Template> templates;
	
	static {
		templates = new ArrayList<>();
		
		templates.add(new Template("1", "EMPLOYEE_LIST", "Employee List", "employee_list"));
		templates.add(new Template("2", "DEPARTMENTS", "Departments", "departments"));
	}

	@SuppressWarnings("static-access")
	public List<Template> getTemplateList() {
		return this.templates;
	}
	
	@SuppressWarnings("static-access")
	public Optional<Template> findById(String id) {
		return this.templates.stream().filter(template -> template.getId().equals(id)).findFirst();
	}
}
