package com.jsp.jdbc_with_CallableStatement.services;

import java.util.List;

import com.jsp.jdbc_with_CallableStatement.dao.LaptopDao;
import com.jsp.jdbc_with_CallableStatement.dto.LaptopDto;

public class LaptopServices {

	LaptopDao dao = new LaptopDao();
	
	public LaptopDto saveLaptopService(LaptopDto laptop) {
		
		return dao.saveLaptopDao(laptop);
	}
	
	public LaptopDto getLaptopByIdServices(int idG) {
		
		return dao.getLaptopByIdDao(idG);
	}
	
	public List<LaptopDto> getAllLaptopsServices(){
			   
		return dao.getAllLaptopsDao();
	}
	
	public int deleteByIdServices(int idD) {
		
		return dao.deleteByIdDao(idD);
	}
	public int updateLaptopNameServices(int idU) {
		
		return dao.updateLaptopNameDao(idU);
	}
	public int updateLaptopColorServices(int idU) {
		
		return dao.updateLaptopColorDao(idU);
	}
	public int updateLaptopPriceServices( int idU) {
		
		return dao.updateLaptopPriceDao(idU);
	}
}


