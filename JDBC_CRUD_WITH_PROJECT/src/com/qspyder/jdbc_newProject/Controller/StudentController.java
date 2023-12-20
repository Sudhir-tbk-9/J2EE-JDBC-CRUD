package com.qspyder.jdbc_newProject.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.qspyder.jdbc_newProject.dao.StudentDao;
import com.qspyder.jdbc_newProject.dto.Student;
import com.qspyder.jdnc_crud_with_Project.Services.StudentServices;

public class StudentController {

	public static void main (String[] args){
	try (Scanner scn = new Scanner(System.in)) {
		StudentServices service = new StudentServices();
		
		System.out.println("#########################################");
		System.out.println("####    Welcome to the Application   ####");
		System.out.println("#########################################");
		
		while(true) {
			
		System.out.println("enter 1 to insert ");
		System.out.println("enter 2 to display individual record");
		System.out.println("enter 3 to display all students data ");
		System.out.println("enter 4 to delete ");
		System.out.println("enter 5 to update ");
		System.out.println("enter 6 to Sort all students data in ascending order basis of id ");
		System.out.println("enter 7 to Sort all students data in ascending order basis of name ");
		System.out.println("enter 8 to insert multiple students records ");
		System.out.println("enter 0 to exit ");
		System.out.println("please select one option from above \nto continue...");
		
		int choice = scn.nextInt();
		
		if (choice == 0) {
			System.out.println("/////////////////////////////////////////////////////////");
			System.out.println("///////////////  Closing the Application  ///////////////");
			System.out.println("/////////////////////////////////////////////////////////");
			break;
		}
		switch (choice) {
		case 1 :{
//		INSERT NEW RECORD
			
			System.out.println("Please enter asked details one by one..");
			System.out.print(" ID : ");
			int id = scn.nextInt();
			scn.nextLine();
			System.out.print(" Name : ");
			String name = scn.nextLine();
			scn.nextLine();
			System.out.print(" Birth year : ");
			int year = scn.nextInt();
			System.out.print(" Birth month : ");
			int month = scn.nextInt();
			System.out.print(" Birth day : ");
			int date = scn.nextInt();
			scn.nextLine();
			System.out.print(" Address : ");
			String address = scn.nextLine();
			
			service.saveStudentService(new Student(id , name ,LocalDate.of(year, month, date) ,address));
			
			
		}break ;
		
//	=============================================================================
		case 2 : {
//		DISPLAY INDIVIDUAL
			System.out.println("enter id to display data");
			int id = scn.nextInt();
			Student student = service.getStudentDetailsByIdServices(id);
			
			if(student != null) {
				System.out.println("==========================================================================================");
				System.out.println(student);
				System.out.println("==========================================================================================");
			}
			else {
				System.out.println("id not present...");
			}
			
		}break ;
//	=============================================================================
		case 3 : {
//		DISPLAY ALL
			
			List<Student> student = service.getStudentAllDetailsServices();
				
			for(Student p : student) {
				System.out.println(p);
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
			}	
			
		}break;
//	=============================================================================
		case 4: {
//		DELETE
			System.out.println("enter the id who's data u want to delete.");
			int del = scn.nextInt();
			
			service.delStudentDetailsByIdServices(del);
			
			if (StudentDao.result == 1) {
				System.out.println("***   RECORD WITH ID: "+del+" DELETED SUCCESSFULLY   ***");
			}
			else {
				System.out.println("***   NO RECORD IS ASSOCIATED WITH ENTERED ID : " +del+ "   ***");
			}
		}break;
		
//	=============================================================================
		case 5 : {
//		UPDATE
			System.out.println("Select what u want to update");
			System.out.println("enter 1 for name");
			System.out.println("enter 2 for dob");
			System.out.println("enter 3 for address");
			int ch = scn.nextInt();
			
			switch(ch){
			
			case  1 : {
				System.out.println("enter student's id whose name you want to update");
				
				int idToUp = scn.nextInt();
				service.updateStudentNameServices(idToUp);
				
				if (StudentDao.result == 1) {
					System.out.println("***   RECORD WITH ID: "+idToUp+" UPDATED SUCCESSFULLY   ***");
				}
				else {
					System.out.println("***   NO ID IS ASSOCIATED WITH ENTERED id: " +idToUp+ "   ***");
				}
			}break;
			
			case 2: {
				System.out.println("enter student's id whose DOB you want to update");
				
				int idToUp = scn.nextInt();
				service.updateStudentDobServices(idToUp);
				
				if (StudentDao.result == 1) {
					System.out.println("***   RECORD WITH ID: "+idToUp+" UPDATED SUCCESSFULLY   ***");
				}
				else {
					System.out.println("***   NO ID IS ASSOCIATED WITH ENTERED id: " +idToUp+ "   ***");
				}
			}break;
			
			case 3 : {
				System.out.println("enter student's id whose address you want to update");
				int idToUp = scn.nextInt();
				service.updateStudentAddressServices(idToUp);
				
				if (StudentDao.result == 1) {
					System.out.println("***   RECORD WITH ID: "+idToUp+" UPDATED SUCCESSFULLY   ***");
				}
				else {
					System.out.println("***   NO ID IS ASSOCIATED WITH ENTERED id: " +idToUp+ "   ***");
				}
			}break;
			
			default : {
				System.out.println("^^^^PLEASE SELECT FROM ABOVE OPTIONS ONLY^^^^");
			}break;
			
			}
		}break;
		
		case 6 :{
	
			List<Student> student = service.getStudentDetailsinASCOrderService();
			
			for(Student p : student) {
				System.out.println(p);
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
			}	
			System.out.println("=======RECORDS FORMATED ON THE BASIS========");
			System.out.println("=========OF ID IN ASCENDING ORDER========");
			
		}break;
		
		case 7 :{
			
			List<Student> student = service.sortStudentByNameAscService();
			
			for(Student p : student) {
				System.out.println(p);
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
			}	
			System.out.println("======RECORDS FORMATED ON THE BASIS========");
			System.out.println("=======OF NAME IN ASCENDING ORDER========");
			
		}break;
		
		case 8 : {
		System.out.println("how many students data u want to insert ? ");
		int count = scn.nextInt();
		
		Student student = null ;

		List<Student> students = new ArrayList<Student> ();

		
		for(int i = 0 ; i<count  ; i++) {
		
			System.out.println("Please enter asked details one by one..");
			System.out.print(" ID : ");
			int id = scn.nextInt();
			scn.nextLine();
			System.out.print(" Name : ");
			String name = scn.nextLine();
			scn.nextLine();
			System.out.print(" Birth year : ");
			int year = scn.nextInt();
			System.out.print(" Birth month : ");
			int month = scn.nextInt();
			System.out.print(" Birth day : ");
			int date = scn.nextInt();
			scn.nextLine();
			System.out.print(" Address : ");
			String address = scn.nextLine();
		
			student = new Student(id , name ,LocalDate.of(year, month, date) ,address); 
			
			students.add(student);
		}
		System.out.println("======RECORDS STORED IN THE DATABASE========");
		
		service.saveMultiplStudentService(students);
		
		}break;
		
		default : {
			System.out.println("^^^^PLEASE SELECT FROM ABOVE OPTIONS ONLY^^^^");
		}break;
//	=============================================================================
		}
		
		}
	}	
	}
}