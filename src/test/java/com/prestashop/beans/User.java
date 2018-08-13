package com.prestashop.beans;
//beans--> used to represent a certain type of object  
//pojo---> plain old java object(with getters and setters)
//model---> used to represent a certain type of object

public class User {
private String firstname;
private String lastName;
private String address;
private String company;
private String city;
public User(String firstname, String lastName, String address, String company, String city) {
	super();
	this.firstname = firstname;
	this.lastName = lastName;
	this.address = address;
	this.company = company;
	this.city = city;
}

public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

	
	
}
