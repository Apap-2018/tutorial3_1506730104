package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import com.apap.tutorial3.model.CarModel;

import org.springframework.stereotype.Service;

public class CarInMemoryService implements CarService{
	private List<CarModel> archiveCar;
	
	public CarInMemoryService() {
		archiveCar = new ArrayList<>();
	}

	@Override
	public void addCar(CarModel car) {
		// TODO Auto-generated method stub
		archiveCar.add(car);
	}

	@Override
	public List<CarModel> getCarList() {
		// TODO Auto-generated method stub
		return archiveCar;
	}

	@Override
	public CarModel getCarDetail(String id) {
		// TODO Auto-generated method stub
		int index;
		for(int i = 0; i < archiveCar.size() - 1; i++) {
			if(archiveCar.get(i) == CarModel(id)) {
				index = i;
			}
		}
		return archiveCar.get(index);
	}
}
