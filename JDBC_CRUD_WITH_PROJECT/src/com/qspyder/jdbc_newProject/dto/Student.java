package com.qspyder.jdbc_newProject.dto;

import java.time.LocalDate;

//public class Student{
	public class Student implements Comparable<Student> {

	int id ;
	String name ;
	LocalDate dob ;
	String address ;
	
	public Student () {
		super();
	}
	
	public Student(int id, String name, LocalDate dob, String address) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Student with id: " + id + " named " + name + ", DOB = " + dob + " , lives in  " + address +"." ;
	}

	@Override
	public int compareTo(Student o) {
		
		return Integer.compare(this.id, id);
	
	}
	
	
	
}
