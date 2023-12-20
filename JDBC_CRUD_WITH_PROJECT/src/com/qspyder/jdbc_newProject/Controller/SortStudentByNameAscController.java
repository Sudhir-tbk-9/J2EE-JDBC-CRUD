package com.qspyder.jdbc_newProject.Controller;

import java.util.List;

import com.qspyder.jdbc_newProject.dto.Student;
import com.qspyder.jdnc_crud_with_Project.Services.StudentServices;

public class SortStudentByNameAscController {

	public static void main(String[] args) {
		StudentServices service = new StudentServices();
		
		List<Student> list = service.sortStudentByNameAscService();
		
		list.forEach(a->System.out.println(a));
	}
}
