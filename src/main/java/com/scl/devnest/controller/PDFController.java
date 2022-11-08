package com.scl.devnest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scl.devnest.model.PDFRequest;
import com.scl.devnest.service.PDFService;

@RestController
@RequestMapping("/api/v1/pdfs")
public class PDFController {
	
	@Autowired
	private PDFService service;

	@RequestMapping(method = RequestMethod.POST)
	public void generatePDF(@RequestBody PDFRequest request, HttpServletResponse response) throws Exception {
		if(request != null) {
			Map<String, Object> params = new HashMap<>();
			
			if(request.getParams() != null) {
				request.getParams().stream().forEach(param -> params.put(param.getKey(), param.getValue()));
				service.generatePDF(request.getTemplateId(), params, response);
			}
		}
	}
}
