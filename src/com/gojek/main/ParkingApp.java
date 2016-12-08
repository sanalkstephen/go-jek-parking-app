package com.gojek.main;

import java.util.List;
import java.util.stream.Collectors;

import com.gojek.parkinglot.ParkingLot;
import com.gojek.parkinglot.Slot;
import com.gojek.vehicle.Car;
import com.gojek.vehicle.IVehicle;

public class ParkingApp {
	
	private ParkingLot parkingLot;
	
	public void runCommand(String command, String[] params) {
		switch(GojekCommands.valueOf(command)) {
		case create_parking_lot:
			createParkingLot(params);
			break;
		case leave:
			leave(params);
			break;
		case park:
			park(params);
			break;
		case status:
			status(params);
			break;
		case slot_number_for_registration_number:
			findSlotsByVehicleRegNum(params);
			break;
		case registration_numbers_for_cars_with_colour:
			findRegNumByVehicleColor(params);
			break;
		case slot_numbers_for_cars_with_colour:
			findSlotsByVehicleRegNum(params);
			break;
		default:
			break;
		}
	}
	
	public void createParkingLot(String[] params) {
		String param = params[1];
		int numSlots = Integer.parseInt(param);
		parkingLot = new ParkingLot(numSlots);
		printOut("Created a parking lot with " + numSlots +" slots");
	}
	
	public void park(String[] params) {
		String regNumber = params[1];
		String color = params[2];
		IVehicle vehicle = new Car(regNumber, color);
		Slot parkedSlot = parkingLot.parkVehicle(vehicle);
		if(parkedSlot != null) {
			printOut("Allocated slot number: " +  parkedSlot.getSerialNumber());
		}
		else {
			printOut("Sorry, parking lot is full");
		}
	}
	
	public void leave(String[] params) {
		String param = params[1];
		int slotNum = Integer.parseInt(param);
		parkingLot.leaveVehicle(slotNum);
		printOut("Slot number " + slotNum + " is free");
	}
	
	public void status(String[] params) {
		if(parkingLot == null) {
			printOut("No Parking lot created");
			return;
		}
		List<Slot> slots = parkingLot.getSlots();
		for(int i=0; i< slots.size(); i++) {
			if(!slots.get(i).isFree()) {
			printOut(slots.get(i).getSerialNumber() + "\t"
					+ slots.get(i).getParkedVehicle().getRegistrationNumber() + "\t"
					+ slots.get(i).getParkedVehicle().getColor());
			}
		}
	}
	
	public void findSlotsByVehicleColor(String[] params) {
		String color = params[1];
		printOut(String.join(",", parkingLot.findSlotsByVehicleColor(color)));
	}
	
	public void findRegNumByVehicleColor(String[] params) {
		String color = params[1];
		printOut(String.join(",", parkingLot.findRegNumByVehicleColor(color)));
	}
	
	public void findSlotsByVehicleRegNum(String[] params) {
		String regNum = params[1];
		printOut(String.join(",", parkingLot.findSlotsByVehicleRegNum(regNum)));
	}
	
	private void printOut(String message) {
		System.out.println(message);
	}
}
