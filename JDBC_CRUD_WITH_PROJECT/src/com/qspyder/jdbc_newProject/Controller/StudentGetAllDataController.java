package com.qspyder.jdbc_newProject.Controller;

import com.qspyder.jdbc_newProject.dto.Student;
import com.qspyder.jdnc_crud_with_Project.Services.StudentServices;

public class StudentGetAllDataController {

	public static void main(String[] args) {
	
		StudentServices service = new StudentServices();
		
		for(Student student : service.getStudentAllDetailsServices() ) {
			
			System.out.println(student);
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
}
}
