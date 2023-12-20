package com.jsp.jdbc_with_CallableStatement.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.jdbc_with_CallableStatement.connection.LaptopConnection;
import com.jsp.jdbc_with_CallableStatement.dto.LaptopDto;

public class LaptopDao {
	public static int result ; 
	static Scanner scn = new Scanner(System.in);
	Connection conn = LaptopConnection.getLaptopConnection();
	
//	================================================================================================	
	public LaptopDto saveLaptopDao(LaptopDto laptop) {
		
		try {
			
			CallableStatement call = conn.prepareCall("call insertLaptop(?,?,?,?)");
			call.setInt(1, laptop.getId());
			call.setString(2, laptop.getName());
			call.setString(3, laptop.getColor());
			call.setDouble(4, laptop.getPrice());
			call.execute();
		
			return laptop ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
//	==================================================================================================
	
	public LaptopDto getLaptopByIdDao(int idG) {
		
		
		try {
			CallableStatement call = conn.prepareCall("call getLaptopById (?)");
			
			call.setInt(1, idG);
		
			ResultSet rs = call.executeQuery();
			
			if(rs.next()) {
				
					return new LaptopDto(rs.getInt("id"),
										 rs.getString("name"),
										 rs.getString("color"),
										 rs.getDouble("price")); 
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
//	========================================================================================================
	
	public List<LaptopDto> getAllLaptopsDao(){
		
		try {
			CallableStatement call = conn.prepareCall("call getAllLaptop()");
		
			ResultSet res = call.executeQuery();
			
			List <LaptopDto> laptop = new ArrayList<LaptopDto>();
			
			LaptopDto lappy ;
			while(res.next()) {
				lappy = new LaptopDto (res.getInt("id"),
						res.getString("name"),
						res.getString("color"),
						res.getDouble("price"));
				
				laptop.add(lappy);
			}
		return laptop ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//	=============================================================================================================
	
	public int deleteByIdDao(int idD) {
		
		try {
			CallableStatement call = conn.prepareCall("call deleteLaptopById (?)");
			call.setInt(1, idD);
			
			result = call.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		return result;
	}
//	===============================================================================================================
	
	public int updateLaptopNameDao(int idU) {
		System.out.println("enter new name for this laptop");
		String nameU = scn.nextLine();
		
		try {
			CallableStatement call = conn.prepareCall("call updateName(?,?)");
			call.setString(1, nameU);
			call.setInt(2, idU); 
		
		result = call.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result ;
	}
//	===============================================================================================================
	
	public int updateLaptopColorDao(int idU) {
		
		System.out.println("enter new color for this laptop");
		String colorU = scn.nextLine();
		try {
			CallableStatement call = conn.prepareCall("call updateColor (?,?)");
			call.setString(1, colorU);
			call.setInt(2, idU);
		
		result = call.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
//	===============================================================================================================
	
	public int updateLaptopPriceDao(int idU) {
		
		System.out.println("enter new price for this laptop");
		double priceU = scn.nextDouble();
		
		try {
			CallableStatement call = conn.prepareCall("call updatePrice (?,?)");
		call.setDouble(1, priceU);
		call.setInt(2, idU);
		
		result = call.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
