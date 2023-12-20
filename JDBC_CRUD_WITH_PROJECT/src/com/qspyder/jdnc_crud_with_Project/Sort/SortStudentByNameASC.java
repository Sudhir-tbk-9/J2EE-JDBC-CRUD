package com.qspyder.jdnc_crud_with_Project.Sort;

import java.util.Comparator;

import com.qspyder.jdbc_newProject.dto.Student;

public class SortStudentByNameASC implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.getName().compareTo(o2.getName());
	}

}
