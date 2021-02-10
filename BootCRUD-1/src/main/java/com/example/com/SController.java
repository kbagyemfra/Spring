package com.example.com;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path= "/student")

// @RequestMapping(path=”/student”) refers to the base URL of the API.
// If we host this using localhost, 
// we will be having something like below
// http:localhost:8080/student as our base URL.

public class SController {
	
	
	@Autowired
	private StudentService serv; 

	// Add new student
		@PostMapping(path="/add")
		public @ResponseBody String addNewStudent (@RequestBody Student s) {
			return serv.addStudent(s);
		}
	
		// Get all students
		@GetMapping(path="/all")
		public @ResponseBody Iterable<Student> getAllStudent() {
			return serv.getAllStudent();
		}
		
		// Get single student by Id
		@GetMapping(path="/{id}")
		public @ResponseBody Optional<Student> getStudentById(@PathVariable(name = "id") Integer id) {
			return serv.getStudent(id);
		}
		
		// Update a Student
		@PostMapping(path="/update/{id}")
		public @ResponseBody String updateStudent(@PathVariable(name = "id") Integer id, @RequestBody 
	        Student student) {
			return serv.updateStudent(id,student);
		}

		
		// Delete a Student
		@DeleteMapping(path="/delete/{id}")
		public @ResponseBody String deleteStudent(@PathVariable(name = "id") Integer id) {
			return serv.deleteStudent(id);
		}
		
		
}
