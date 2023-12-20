package com.jspyder.jdbc_mobileApplication.controller;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import com.jspyder.jdbc_mobileApplication.dtoORntt.Mobile;
import com.jspyder.jdbc_mobileConnection.connector.MobileConnection;

//============================================================================================================

public class MobileController {
	public static void main(String[] args) {
		System.out.println("========== WELCOME TO THE APP ==========");
		Scanner scn = new Scanner(System.in);
		Mobile mobile = null;
				
		Connection connect = MobileConnection.getMobileConnection();
		
				while(true) {
					System.out.println("enter 1  for insert");
					System.out.println("enter 2  for update");
					System.out.println("enter 3  for delete");
					System.out.println("enter 4  to display");
					System.out.println("enter 0 to exit ..");
//		OR=====>>>> System.out.println("1.Insert\n2.Delete\n3.getMobileById");
					
					System.out.println("please choose one option from above...");
				
					int ch = scn.nextInt();
					
					 if (ch == 0) {
						 	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			                System.out.println("| Exiting the application. Goodbye! |");
			                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			                break; // Exit the loop
			            }

					
					switch(ch) {
									
//	=================================================================================================			
					case 1 : {
						System.out.println("enter id");
						int id = scn.nextInt();
						
						System.out.println("enter name");
						String name = scn.next();
						
						System.out.println("enter color");
						String color = scn.next();
						
						System.out.println("enter price");
						double price = scn.nextDouble();
						
						System.out.println("enter purchase date");
						System.out.println("enter year of purchase");
						int purchaseYear = scn.nextInt();
						
						System.out.println("enter month of purchase");
						int purchaseMonth = scn.nextInt();
						
						System.out.println("enter date of purchase");
						int purchaseDay = scn.nextInt();
						
						mobile = new Mobile (id , name ,color ,price , LocalDate.of(purchaseYear, purchaseMonth, purchaseDay));
						
//					
//	STEP - 3 : CREATE STATEMENT ======================================================
					
					try {
						String insertQuery = "insert into mobile values(?,?,?,?,?)";
						PreparedStatement prepStatement = connect.prepareStatement(insertQuery) ;
						
						 prepStatement.setInt(1, mobile.getId());
						 prepStatement.setString(2, mobile.getName());
						 prepStatement.setString(3, mobile.getColor());
						 prepStatement.setDouble(4, mobile.getPrice());
						 prepStatement.setObject(5, mobile.getPurchaseDate());
						 
						 prepStatement.execute();
						 System.out.println("====[ Data Inserted Successfully ]====");
						 } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}break;
//======================================================================================================					
					case 2 : {
						System.out.println("Select what u want to update");
						System.out.println("enter 1 for name");
						System.out.println("enter 2 for color");
						System.out.println("enter 3 for price");
						System.out.println("enter 4 for purchase date");
						int choice = scn.nextInt();
						
						switch(choice){
						
						case  1 : {
							System.out.println("enter mobile id to update name");
							int id = scn.nextInt();

							System.out.println("enter new  mobile name");
							String name = scn.next();
							name = name + scn.nextLine();
							
							String updateNameQuery = "update mobile set name=? where id=?";
							
							try {
								PreparedStatement  preparedStatement = connect.prepareStatement(updateNameQuery);
								
								preparedStatement.setInt(2, id);
								preparedStatement.setString(1, name);
								
								int a=preparedStatement.executeUpdate();
								
								if(a==1) {
									System.out.println("=====[ Data Updated Successfully ]=====");
								}else {
									System.out.println("id not found");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
						}break ;
						
						case 2 : {
							System.out.println("enter mobile id to update color");
							int id = scn.nextInt();

							System.out.println("enter new  mobile color");
							String color = scn.next();
							color = color + scn.nextLine();
							
							String updateColorQuery = "update mobile set color=? where id=?";
							
							try {
								PreparedStatement  prepStatement = connect.prepareStatement(updateColorQuery);
								
								prepStatement.setInt(2, id);
								prepStatement.setString(1,color);
								
								int a=prepStatement.executeUpdate();
								
								if(a==1) {
									System.out.println("data updated");
								}else {
									System.out.println("id not found");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							

						}break;
		
						case 3 : {
							System.out.println("enter mobile id to update price");
							int id = scn.nextInt();

							System.out.println("enter new  mobile price");
							Double price = scn.nextDouble();
//							
							String updatePriceQuery = "update mobile set price=? where id=?";
							
							try {
								PreparedStatement  prepStatement = connect.prepareStatement(updatePriceQuery);
								
								prepStatement.setInt(2, id);
								prepStatement.setDouble(1, price);
								
								int a=prepStatement.executeUpdate();
								
								if(a==1) {
									System.out.println("data updated");
								}else {
									System.out.println("id not found");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							

						}break;
						
						case 4 : {
							System.out.println("enter mobile id to update purchase date");
							int id = scn.nextInt();

							System.out.println("enter new  mobile purchase Year");
							int purchaseYear = scn.nextInt();
							System.out.println("enter new  mobile purchase Month");
							int purchaseMonth =  scn.nextInt();
							System.out.println("enter new  mobile purchase Date");
							int purchaseDate =  scn.nextInt();
							
							LocalDate newDateOfPurchase = LocalDate.of(purchaseYear, purchaseMonth, purchaseDate);
							
							String updateNameQuery = "update mobile set purchaseDate=? where id=?";
							
							try {
								PreparedStatement  prepStatement = connect.prepareStatement(updateNameQuery);
								
								prepStatement.setInt(2, id);
								prepStatement.setDate(1,Date.valueOf(newDateOfPurchase));
								
								int a=prepStatement.executeUpdate();
								
								if(a==1) {
									System.out.println("data updated");
								}else {
									System.out.println("id not found");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							

						}break;
			
			}break;
					}
//	===============================================================================================================
					
					case 3 : {
						
//							
							System.out.println("enter the product id to delete that product");
							int id = scn.nextInt();
							
							String deleteQuery = "delete from mobile where id = ? ";
						
					try {
							PreparedStatement prepStatement = connect.prepareStatement(deleteQuery);
							prepStatement.setInt(1,id);
							
							int a =	prepStatement.executeUpdate();
							
							if(a==1) {	
								System.out.println("=============== DATA DELETED =================");
							}
							else {
								System.out.println("id not found.....");
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}break;
//	=======================================================================================================================
					case 4 : {
						
						System.out.println("enter id to display the mobile unit");
						
						int idDis  = scn.nextInt();
						
						String displayQuery = "select * from mobile where id = ?";						
					
						try {
						PreparedStatement prepStatement = connect.prepareStatement(displayQuery);
						
						prepStatement.setInt(1,idDis);

						ResultSet rset =	prepStatement.executeQuery();
						
						if(rset.next()) {	
							
							System.out.println("=============== DATA =================");
							int id = rset.getInt("id");
							String name = rset.getString("name");
							String color = rset.getString("color");
							double price = rset.getDouble("price");
							LocalDate locDate = rset.getDate("purchaseDate").toLocalDate();
							
							mobile = new Mobile(id,name,color,price,locDate);
							System.out.println(mobile);
							
						}
						else {
							System.out.println("=== No Mobile is Saved with entered id ===");
						}
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}break ;

//	========================================================================================================================
						}
					}
					}
				
	}

