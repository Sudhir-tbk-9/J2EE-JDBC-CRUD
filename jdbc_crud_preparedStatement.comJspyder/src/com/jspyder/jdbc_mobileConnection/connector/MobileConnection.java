package com.jspyder.jdbc_mobileConnection.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class MobileConnection {
	

	public static Connection getMobileConnection() {
		// TODO Auto-generated method stub
		try {
			
			Driver driver = new Driver() ;
			DriverManager.registerDriver(driver);
			
			String url = "jdbc:mysql://localhost:3306/jdbc-am1130am" ;
			String user = "root";
			String pass = "root";
			
			return DriverManager.getConnection(url ,user , pass);
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
}
//===============================================