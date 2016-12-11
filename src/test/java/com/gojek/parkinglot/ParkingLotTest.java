package com.gojek.parkinglot;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gojek.vehicle.Car;

public class ParkingLotTest {
	
	int slots = 6;
	
	@Test
	public void createParkingLotTest() {
		ParkingLot lot = new ParkingLot(slots);
		assertEquals(slots, lot.getSlots().size());
	}

	@Test
	public void parkVehicleTest() {
		ParkingLot lot = new ParkingLot(slots);
		Slot slot = lot.parkVehicle(new Car("", ""));
		assertEquals("", slot.getParkedVehicle().getRegistrationNumber());
		assertEquals("", slot.getParkedVehicle().getColor());
	}
	
	@Test
	public void leaveVehicleTest() {
		ParkingLot lot = new ParkingLot(slots);
		assertTrue(lot.leaveVehicle(3));
	}
}
