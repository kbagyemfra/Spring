package com.example;

public class Contact {

	private String name;
	private String race;
	private String country;
	private String area;
	
	public Contact() {
		super();
		
	}
	
	 public Contact(String name, String race, 
			 		String country, String area) {
	        super();
	        this.name = name;
	        this.race = race;
	        this.country = country;
	        this.area = area;
	    }

	public String getName() {
		return name;
	}

	public String getRace() {
		return race;
	}

	public String getCountry() {
		return country;
	}

	public String getArea() {
		return area;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setArea(String area) {
		this.area = area;
	}
	 
	 
	 
}
