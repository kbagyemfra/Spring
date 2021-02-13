package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Employee;

// Class is made to work with the employee class
// and provide an access point 

@Service
public class EmployeeService {
	
	public Employee createEmployee(String name, String empId) { // imported from Employee Class
		
		
		Employee emp = new Employee(); 
		
		emp.setName(name);
		emp.setEmpId(empId);
		return emp;
		
	}

	public void deleteEmployee(String empId) {}
	
}
