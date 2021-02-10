package com.example.com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

// Hibernate automatically translates any 
// @Entity annotated class in to a table. 
// make sure you create the Entity class, 
// named exactly same as in the database table.
public class Student {

	@Id // @Id annotation specifies the primary key of the Entity. 
	
	// And @GeneratedValue(strategy=GenerationType.AUTO) specifies 
	// that for any new record inserted the primary key will be auto generated.
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	
	private String name;
	private String address;
	private String classid;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getClassid() {
		return classid;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	
	
}
