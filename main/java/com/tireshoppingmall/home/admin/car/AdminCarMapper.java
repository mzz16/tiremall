package com.tireshoppingmall.home.admin.car;

import java.util.List;

import com.tireshoppingmall.home.admin.car.SearchCarDTO;

public interface AdminCarMapper {

	

	int getCarCount(SearchCarDTO search);


	CarDTO getCar(CarDTO c);

	List<CarDTO> getAllCar();

	int regCar(CarDTO c);

	int updatecar(CarDTO c);

	int deletecar(CarDTO c);

	List<CarDTO> getCarlists(SearchCarDTO search);


	List<CarDTO> getAllCar(SearchCarDTO search);


	List<CarBrandDTO> getAllCarBrands();


	int deletebrand(CarBrandDTO c);


	int regbrand(CarBrandDTO c);
	
	

	
}
