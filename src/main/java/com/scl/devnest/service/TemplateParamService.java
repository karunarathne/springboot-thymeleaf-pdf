package com.scl.devnest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.scl.devnest.model.TemplateParam;

@Service
public class TemplateParamService {
	
	private static List<TemplateParam> templateParams;
	
	static {
		templateParams = new ArrayList<>();
		
		templateParams.add(new TemplateParam("1", "generatedBy", ""));
		templateParams.add(new TemplateParam("1", "generatedTimestamp", ""));
		
		templateParams.add(new TemplateParam("2", "lastModifiedBy", ""));
		templateParams.add(new TemplateParam("2", "lastModifiedTimestamp", ""));
	}

	@SuppressWarnings("static-access")
	public List<TemplateParam> findByTemplateId(String templateId) {
		return this.templateParams.stream().filter(param -> param.getTemplateId().
				equals(templateId)).collect(Collectors.toList());
	}
}
