package com.qspyder.jdbc_newProject.Controller;

import com.qspyder.jdbc_newProject.dto.Student;
import com.qspyder.jdnc_crud_with_Project.Services.StudentServices;

public class StudentGetByIdController {
public static void main(String[] args, int id) {
	
	StudentServices service= new StudentServices();
	
	Student student = service.getStudentDetailsByIdServices(id);
	
	if(student != null) {
		System.out.println(student);
	}
	else {
		System.out.println("entered id not found");
	}
	
}
}
