package com.scl.devnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scl.devnest.model.TemplateParam;
import com.scl.devnest.service.TemplateParamService;

@RestController
@RequestMapping("/api/v1/template-params")
public class TemplateParamController {
	
	@Autowired
	private TemplateParamService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TemplateParam>> findParamsByTemplateId(@RequestParam("templateId") String templateId) {
		return ResponseEntity.ok(service.findByTemplateId(templateId));
	}
}
