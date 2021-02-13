package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService serv; // instance of EmployeeService class
	
	
	// This method is used to request in the web browser 
	// for adding an employee
	
	@RequestMapping(value = "/add/employee", method = RequestMethod.GET)
						//What you put at the end of local:8080/" "
	
	public Employee addEmployee(@RequestParam("name") String name, 
								@RequestParam("empId") String empId){
		
		return serv.createEmployee(name, empId); 
	}
	
	@RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
	public String removeEmployee(@RequestParam("name") String empId){
		
		 serv.deleteEmployee(empId); 
		 
		 return "Employee removed and gone";
	}
	
}


