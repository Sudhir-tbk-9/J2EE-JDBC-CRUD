package com.qspyder.jdnc_crud_with_Project.Services;

import java.util.Collections;
import java.util.List;

import com.qspyder.jdbc_newProject.dao.StudentDao;
import com.qspyder.jdbc_newProject.dto.Student;
import com.qspyder.jdnc_crud_with_Project.Sort.SortStudentByNameASC;

public class StudentServices {
	
	StudentDao dao = new StudentDao();

	public Student saveStudentService (Student student) {
		
		return dao.saveStudentDao(student);
	}
	
	public Student getStudentDetailsByIdServices(int id) {
	
		return dao.getStudentDetailsById(id);
	}
	
	public List<Student> getStudentAllDetailsServices(){
		
		return dao.getStudentAllDetailsDao();
	}
	
	public int delStudentDetailsByIdServices(int del) {
		
		return dao.delStudentDao(del);
	}
	
	public int updateStudentNameServices(int idToUp) {
		
		return dao.updateStudentNameDao(idToUp);
	}
			  
	public int updateStudentDobServices(int idToUp) {
		
		return dao.updateStudentDobDao(idToUp);
	}
	
	public int updateStudentAddressServices(int idToUp) {
	
	return dao.updateStudentAddressDao(idToUp);
}
	 public List<Student> getStudentDetailsinASCOrderService(){
		 
		 return dao.getStudentDetailsinASCOrderDao();
	 }
	 
	 public List<Student> sortStudentByNameAscService(){
		 List<Student> st=dao.getStudentAllDetailsDao();
		 Collections.sort(st, new SortStudentByNameASC());
		return st;
		 
	 }
	 
	 public List<Student> saveMultiplStudentService(List<Student> student){
			
		 return dao. saveMultiplStudentDao(student);
	
	
	 }
	 
}


