package com.gojek.vehicle;

public class Car implements IVehicle {
	
	private String registrationNumber;
	
	private String color;
	
	public Car(String regNum, String color) {
		this.registrationNumber = regNum;
		this.color = color;
	}

	@Override
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	@Override
	public String getColor() {
		return color;
	}

}
