package com.jspyder.jdbc_1130am_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProductController {

	public static void main(String[] args) {
		
		Connection connection = null ;
//	STEP 1 : LOAD OR REGISTER DRIVER
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 
		
//	STEP 2 : CREATE CONNECTION 	
		String url = "jdbc:mysql://localhost:3306/jdbc-am1130am" ;
		String user = "root" ;
		String pass = "root";
		
	connection = DriverManager.getConnection(url , user , pass) ;
		
//	STEP 3 : CREATE STATEMENT 
		Statement statement = connection.createStatement() ;
		
//	STEP 4 : EXECUTE QUERY
		String insertQuery = "insert into product values(155 , 'hard-disk' , 5699)";
		
		statement.execute(insertQuery);
		
		System.out.println("========== DATA STORED ============");
		
		System.out.println(connection);
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//	STEP 5 : CLOSE CONNECTION

		finally {
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
