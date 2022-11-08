package com.scl.devnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scl.devnest.model.Template;
import com.scl.devnest.service.TemplateService;

@RestController
@RequestMapping("/api/v1/templates")
public class TemplateController {

	@Autowired
	private TemplateService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Template>> getTemplateList() {
		return ResponseEntity.ok(service.getTemplateList());
	}
}
