package com.jspyder.jdbc_1130am_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteProductController {
	

	public static void main(String[] args) {
		
		Connection connection = null ;
		
//=======================================================================================================			
//		load driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//=======================================================================================================			
//		create connection
			String url = "jdbc:mysql://localhost:3306/jdbc-am1130am"; 
			String user = "root";
			String pass = "root";
			
			connection = DriverManager.getConnection(url, user, pass) ;
//		System.out.println(connection);

//=======================================================================================================			
//		create statement
			Statement statement = connection.createStatement() ;
			
//=======================================================================================================			
//		execute query
			String deleteQuery = "delete from product where id = 105" ;
			
		int a =	statement.executeUpdate(deleteQuery);
		
		if(a==1) {	
			System.out.println("=============== DATA DELETED =================");
		}
		else {
			System.out.println("id not found.....");
		}
		
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//=======================================================================================================			
//		close connection
		finally { 
			
			try {
				connection.close();
			} catch (NullPointerException |SQLException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
