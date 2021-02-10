package com.example;

import java.util.ArrayList;
import java.util.List;

//a business class that implements 
// a method to return a hard-coded List of Contact objects

public class ContactBusiness {

	 public List<Contact> getContactList() {
	        List<Contact> listContact = new ArrayList<>();
	         
	        listContact.add(new Contact("Marry John", "American", "USA", "East Coast"));
	        listContact.add(new Contact("Tom Smith", "English", "England", "South London"));
	        listContact.add(new Contact("John Purcell", "Irish", "Ireland", "Dublin"));
	        listContact.add(new Contact("Siva Krishna", "Greek", "Greece", "Ephesus"));
	 
	        return listContact; 
	 }
}
