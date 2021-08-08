package com.responseStructure.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.responseStructure.pojo.Company;
import com.responseStructure.pojo.Employee;
import com.responseStructure.pojo.EmployeeDetails;
import com.responseStructure.pojo.EmployeeRequest;
import com.responseStructure.pojo.WorkHistory;
import com.responseStructure.service.EmployeeService;
import com.responseStructure.util.XMLService;

@RestController
public class EmployeeContoller {

	@PostMapping(value = "/employee/xml/detail")
	public String getEmployeeDetail(@RequestBody String request) throws JAXBException, IOException, URISyntaxException, JSchException, SftpException {

		// Step 1:Convert XML to bean
		EmployeeRequest requestData = XMLService.performUnmarshaling(EmployeeRequest.class, request);
		
		// Step 2: Process data
		EmployeeService employeeService = new EmployeeService();
		return employeeService.getEmployeeData(requestData);
	}
	
}
