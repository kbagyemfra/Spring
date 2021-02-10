package com.example.com;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service annotation is used to indicate classes
// with some business functionalities or business logic

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	// add new student method
	public String addStudent(Student s) {

		try { // try to save the name

			repo.save(s); // this .save() is from CrudRepository
			return "save a sucess"; // if sucessful will return saved

		} catch (Exception e) { // if catches an exception

			return "failed attempt"; // will return a failed attempt
		}
	}

	
	
	// Update a Student
	public String updateStudent(Integer id, Student s) {
		// updateStudent() method facilitates updating an existing student record.
		
		try {
			
			// The only difference is that we need to set the primary key
			// of the record to be updated of the new Student object
			s.setId(id);
			
			// We can use the same save() method in CrudRepository interface for updating as well
			repo.save(s);

			return "Input has been Updated";

		}

		catch (Exception e) {
			return "Update has Failed";
		}
	}

	
	
	
	// Get all students
	public Iterable<Student> getAllStudent() {
		
		//getAllStudent() method ^^ facilitates retrieving all the student records in the database. 
		//For this we use the findAll() method below in Crudrepository interface.
		return repo.findAll();
	}

	
	// Get single student by Id
	public Optional<Student> getStudent(Integer id) {
		
	//	getStudent() method above facilitates retriving a single Student record
		// from the database by id (primary key). 
		
	//	We use the CrudRepository’s findById() method below for this.
	//  It takes the primary key or the id of the record to be retrieved as the only input parameter.
		
		return repo.findById(id);
	}

	
	
	// Delete a Student
	public String deleteStudent(Integer id) {
		
// deleteStudent() method facilitates deleting a single Student record from the database
//		by id (primary key). 
		try {
			repo.deleteById(id);
			
		//	We use the deleteById() method above for this. 
		//	It takes the primary key or the id of the record
		//	to be deleted as the only input parameter.		
				
			return "Student Deleted";
		
		} catch (Exception e) {
			return "Deletion has Failed";
		}
	}

}
