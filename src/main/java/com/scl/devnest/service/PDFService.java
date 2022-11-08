package com.scl.devnest.service;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.scl.devnest.model.Template;

@Service
public class PDFService {
	
	private static final String TEMPLATE_CODE_EMPLOYEE_LIST = "EMPLOYEE_LIST";
	private static final String TEMPLATE_CODE_DEPARTMENT_LIST = "DEPARTMENTS";
	
	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Value("${thymeleaf.template.folder}")
	private String templateFolder;
	
	@Value("${thymeleaf.template.extension}")
	private String templateExtension;
	
	public void generatePDF(String templateId, Map<String, Object> params, HttpServletResponse response) throws Exception {
		Optional<Template> templateOptional = templateService.findById(templateId);
		
		if(templateOptional.isPresent()) {
			Template template = templateOptional.get();
			params = fillTemplateSpecificOtherParams(template.getCode(), params);
			
			response.setContentType("application/pdf");
	        response.setHeader("Content-disposition","attachment;filename="+ "testPDF.pdf");
	        
	        ITextRenderer renderer = new ITextRenderer();
	        renderer.setDocumentFromString(parseTemplate(template.getFileName(), params));
	        renderer.layout();
	        renderer.createPDF(response.getOutputStream());
		}
	}
	
	private String parseTemplate(String template, Map<String, Object> params) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        
        templateResolver.setPrefix(templateFolder);
        templateResolver.setSuffix(templateExtension);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        
        Context context = new Context();
        
        if(params != null) {
            params.entrySet().stream().forEach(entry -> context.setVariable(entry.getKey(), entry.getValue()));
        }
        
        return templateEngine.process(template, context);
    }
	
	private Map<String, Object> fillTemplateSpecificOtherParams(String templateCode, Map<String, Object> params) {
		if(TEMPLATE_CODE_EMPLOYEE_LIST.equals(templateCode)) {
			params.put("employees", employeeService.getEmployeeList());
		} else if(TEMPLATE_CODE_DEPARTMENT_LIST.equals(templateCode)) {
			params.put("departments", departmentService.getDepartmentList());
		}
		
		return params;
	}
}
