package com.qspyder.jdbc_newProject.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.qspyder.jdbc_crud_with_Project.Connection.StudentConnection;
import com.qspyder.jdbc_newProject.dto.Student;

public class StudentDao {
public static int result ;
static Scanner scn = new Scanner(System.in);
	Connection conn = StudentConnection.getStudentConnection();

	public Student saveStudentDao (Student student) {
		
		String insert = "insert into student values (?,?,?,?)";
		
		try {
			PreparedStatement prepStatement = conn.prepareStatement(insert);
			prepStatement.setInt(1, student.getId());
			prepStatement.setString(2, student.getName());
			prepStatement.setDate(3, Date.valueOf(student.getDob()) );
			prepStatement.setString(4, student.getAddress());
		
			int a = prepStatement.executeUpdate();

			if(a==1) {
			System.out.println("========  Data Inserted  ==========");	
			}
			else {
				System.out.println("Something went wrong, Data doesn't stored ...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
		
	}
//	===================================================================================
	public Student getStudentDetailsById(int id) {
		
		String selectQuery = "select * from student where id = ?" ;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(selectQuery);
			
			ps.setInt(1, id);
			ResultSet a =  ps.executeQuery();
			
			if(a.next()) {
				
			return new Student(a.getInt("id"),
					a.getString("name"),
							a.getDate("dob").toLocalDate(),
									a.getString("address"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
	
//	=======================================================================================
	
public List<Student> getStudentAllDetailsDao() {
		
		String selectQueryAll = "select * from student" ;
		
		PreparedStatement ps;
	
			try {
				ps = conn.prepareStatement(selectQueryAll);
				ResultSet a =  ps.executeQuery();
				
				List <Student> students = new ArrayList<Student>() ;
				
				Student student ; 
						while(a.next()) {
							student  = new Student(a.getInt("id"),
							a.getString("name"),
							a.getDate("dob").toLocalDate(),
									a.getString("address"));
							
							 students.add(student) ;
				}
						return students ;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null ;	
}
//=======================================================================		
		
	public int delStudentDao(int del) {
			
		String deleteQuery = "delete from student where id = ?" ;
		
		PreparedStatement prepState ;
		
		try {
			prepState = conn.prepareStatement(deleteQuery);
			prepState.setInt(1, del);
			
			 result = prepState.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result ;
}
//	===============================================================================
	public int updateStudentNameDao(int idToUp) {
		
		System.out.println("enter the new name for this record");
		String name = scn.next();
		
		String updateNameQuery = "update student set name = ? where id = ? ";
		PreparedStatement pst ;
		
		try {
			pst = conn.prepareStatement(updateNameQuery);
			pst.setInt(2, idToUp);
			pst.setString(1,name );
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
//===================================================================================================
	
	public int updateStudentDobDao(int idToUp) {
		
		System.out.println("enter new dob for this record");
		System.out.println();
		System.out.print("enter birth year : ");
		int year = scn.nextInt();
		System.out.print("enter birth month : ");
		int month = scn.nextInt();
		System.out.print("enter birth date : ");
		int date = scn.nextInt();
		
		LocalDate dob = LocalDate.of(year, month, date);
		
		
		String updateDobQuery = "update student set dob = ? where id = ?" ;
		
		PreparedStatement pstmt ;
		
		try {
			pstmt = conn.prepareStatement(updateDobQuery);
			pstmt.setInt(2, idToUp);
			pstmt.setDate(1,Date.valueOf(dob));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
//	===================================================================================
	
	public int updateStudentAddressDao(int idToUp) {
		
		System.out.println("enter new address for this record");
		String address = scn.nextLine();
		
		String updateAddressQuery = "update student set address = ? where id = ?" ;
		
		PreparedStatement preState ;
		
		try {
			preState = conn.prepareStatement(updateAddressQuery);
			preState.setString(1, address);
			preState.setInt(2, idToUp);
			
			result = preState.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
//	===========================================================================================
	
	
	public List<Student> getStudentDetailsinASCOrderDao()  {
		
	
			List<Student> st = 	getStudentAllDetailsDao();
			
			Collections.sort(st);
			
			return st;
			
			
			
}
//	================================================================================================
	
	public List<Student> saveMultiplStudentDao(List<Student> student){
		
		String insertQuery = "insert into student values(?,?,?,?)" ;
		try {
			PreparedStatement prep = conn.prepareStatement(insertQuery);
			
			for(Student stud : student){
				
				prep.setInt(1, stud.getId());
				prep.setString(2, stud.getName());
				prep.setObject(3, stud.getDob());
				prep.setString(4, stud.getAddress());
			
				prep.addBatch();
			}
		prep.executeBatch();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student ;
	}
}