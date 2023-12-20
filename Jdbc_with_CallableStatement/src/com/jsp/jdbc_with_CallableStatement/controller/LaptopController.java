package com.jsp.jdbc_with_CallableStatement.controller;
import java.util.List;
import java.util.Scanner;

import com.jsp.jdbc_with_CallableStatement.dao.LaptopDao;
import com.jsp.jdbc_with_CallableStatement.dto.LaptopDto;
import com.jsp.jdbc_with_CallableStatement.services.*;

public class LaptopController {

	public static void main(String[] args) {
//		=========================================================================================
		try (Scanner scn = new Scanner(System.in)) {
			
			LaptopServices service = new LaptopServices();
			
			System.out.println("##########################################################");
			System.out.println("##########===== Welcome to the Application =====##########");
			System.out.println("##########################################################");
			
			while(true) {
				
			System.out.println("enter 1 to insert ");
			System.out.println("enter 2 to display individual record");
			System.out.println("enter 3 to display all students data ");
			System.out.println("enter 4 to delete ");
			System.out.println("enter 5 to update ");
			System.out.println("enter 0 to exit ");
			System.out.println("please select one option from above to continue...");
			
			int choice = scn.nextInt();
			
			if (choice == 0) {
				System.out.println("/////////////////////////////////////////////////////////");
				System.out.println("///////////////  Closing the Application  ///////////////");
				System.out.println("/////////////////////////////////////////////////////////");
				break;
			}
			switch (choice) {
			
			case 1 :{
//			INSERT NEW RECORD
				
				System.out.println("Please enter asked details one by one..");
				
				System.out.print(" ID : ");
				int id = scn.nextInt();
				scn.nextLine();
				System.out.print(" Name : ");
				String name = scn.nextLine();
				
				System.out.print(" Color : ");
				String color = scn.nextLine();
				
				System.out.print(" Price : ");
				double price= scn.nextDouble();
				
				LaptopDto laptop = new LaptopDto(id,name,color,price);
						
				LaptopDto laptop1 = service.saveLaptopService(laptop);	
						
				if(laptop1 != null) {
					System.out.println("============= DATA STORED SUCCESSFULY ==================");
					
				}	else {
					
					System.out.println("============= DATA NOT STORED =================");
				}	
						
					
			}break ;
//===============================================================================================

			case 2 : {
//				DISPLAY INDIVIDUAL
					System.out.println("enter id to display data");
					
					int idG = scn.nextInt();
					
					LaptopDto indiDisplay= service.getLaptopByIdServices(idG);
					
					if(indiDisplay != null) {
						System.out.println("==========================================================================================");
						System.out.println(indiDisplay);
						System.out.println("==========================================================================================");
					}
					else {
						System.out.println("====================ENTERED ID NOT FOUND====================");
					}
			}break;
//		===========================================================================================
			
			case 3 : {
//				DISPLAY ALL
				List<LaptopDto> display = service.getAllLaptopsServices();
				
				for(LaptopDto p : display) {
					System.out.println(p);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}
				
			}break;
//		=========================================================================================
			case 4 : {
//				DELETE INDIVIDUAL
				System.out.println("enter id who's record you want to delete.");
				int idD = scn.nextInt();
				
				 service.deleteByIdServices(idD);
//				
				if(LaptopDao.result == 1) {
					System.out.println("================RECORD WITH ID : "+idD+" DELETED SUCCESSFULLY=====================");
				}
				else {
					System.out.println("================ENTERED ID NOT FOUND===================");
				}
			}break;
//		=========================================================================================
			case 5 : {
//				UPDATE RECORD
				System.out.println("Select what u want to update");
				System.out.println("enter 1 for name");
				System.out.println("enter 2 for color");
				System.out.println("enter 3 for price");
				int ch = scn.nextInt();
				
				switch(ch){
				
				case  1 : {
					System.out.println("enter laptop's id whose brand you want to update");
					int idU = scn.nextInt();
					
					service.updateLaptopNameServices(idU);
					
					if (LaptopDao.result == 1) {
						System.out.println("***   RECORD WITH ID: "+idU+" UPDATED SUCCESSFULLY   ***");
					}
					else {
						System.out.println("***   NO RECORD IS ASSOCIATED WITH ENTERED id: " +idU+ "   ***");
					}
				}break;
//				__________________________________________________________________________________________
				case 2: {
					System.out.println("enter laptop's id whose color you want to update");
					
					int idU = scn.nextInt();
					service.updateLaptopColorServices(idU);
					
					if (LaptopDao.result == 1) {
						System.out.println("***   RECORD WITH ID: "+idU+" UPDATED SUCCESSFULLY   ***");
					}
					else {
						System.out.println("***   NO ID IS ASSOCIATED WITH ENTERED id: " +idU+ "   ***");
					}
				}break;
				
//				__________________________________________________________________________________________
				case 3 : {
					System.out.println("enter laptop's id whose price you want to update");
					int idU = scn.nextInt();
					service.updateLaptopPriceServices(idU);
					
					if (LaptopDao.result == 1) {
						System.out.println("***   RECORD WITH ID: "+idU+" UPDATED SUCCESSFULLY   ***");
					}
					else {
						System.out.println("***   NO ID IS ASSOCIATED WITH ENTERED id: " +idU+ "   ***");
					}
				}break;
				
				default : {
					System.out.println("^^^^PLEASE SELECT FROM ABOVE OPTIONS ONLY^^^^");
				}break;
				
				}
		
			}break ;
//      =============================================================================================
			default : {
				System.out.println("^^^^PLEASE SELECT FROM ABOVE OPTIONS ONLY^^^^");
			}break;
			}
	
			}
		}
	}
}
