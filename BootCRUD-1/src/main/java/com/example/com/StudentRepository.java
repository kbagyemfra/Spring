package com.example.com;

import org.springframework.data.repository.CrudRepository;


// First parameter (Student) is the type of entity which the Repository is working with. 
// The second parameter (Integer) is the type of Id (Primary Key) of this entity.

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
