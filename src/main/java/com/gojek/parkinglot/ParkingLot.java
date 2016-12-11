package com.gojek.parkinglot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gojek.vehicle.IVehicle;

public class ParkingLot {
	
	List<Slot> slots;
	
	/**
	 * Create a parking lot with the slots provided
	 * @param numberOfSlots
	 */
	public ParkingLot(int numberOfSlots) {
		this.slots = new ArrayList<>();
		for(int i=1; i<= numberOfSlots; i++) {
			Slot slot  = new Slot(i);
			this.slots.add(slot);
		}
	}
	
	/**
	 * Park the Vehicle in the nearest available slot
	 * @param vehicle
	 * @return
	 */
	public Slot parkVehicle(IVehicle vehicle) {
		Slot parkSlot = findNearestSlot();
		if(parkSlot != null) {
			parkSlot.parkVehicle(vehicle);
		}
		return parkSlot;
	}
	
	/**
	 * Leave the vehicle from the given slot
	 * @param slotNum
	 * @return true if successfully left 
	 */
	public boolean leaveVehicle(int slotNum) {
		Slot slot = slots.get(slotNum-1);
		slot.setFree();
		return slot.isFree();
	}
	
	/**
	 * @return all Slots on the Parking Lot
	 */
	public List<Slot> getSlots() {
		return slots;
	}
	
	public List<String> findSlotsByVehicleColor(String color) {
		Stream<Slot> parkedSlots = slots.stream().filter(
				a -> a.getParkedVehicle() != null);
		Stream<Slot> sameColorSlots = parkedSlots.filter(a -> a.getParkedVehicle()
				.getColor()
				.equalsIgnoreCase(color));
		return sameColorSlots.map(s -> String.valueOf(s.getSerialNumber()))
				.collect(Collectors.toCollection(ArrayList::new));
		
//		return slots.stream().filter(
//				a -> a.getParkedVehicle() != null)
//				.filter(a -> a.getParkedVehicle()
//						.getColor()
//						.equalsIgnoreCase(color))
//				.map(s -> String.valueOf(s.getSerialNumber()))
//				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public List<String> findRegNumByVehicleColor(String color) {
		return slots.stream().filter(
				a -> a.getParkedVehicle() != null)
				.filter(a -> a.getParkedVehicle()
						.getColor()
						.equalsIgnoreCase(color))
				.map(s -> s.getParkedVehicle().getRegistrationNumber())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public List<String> findSlotsByVehicleRegNum(String regNum) {
		return slots.stream().filter(
				a -> a.getParkedVehicle() != null)
				.filter(a -> a.getParkedVehicle()
						.getRegistrationNumber()
						.equalsIgnoreCase(regNum))
				.map(s -> String.valueOf(s.getSerialNumber()))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	/**
	 * @return Slot - The nearest slot from the entry
	 */
	private Slot findNearestSlot() {
		for(int i=0; i < slots.size(); i++) {
			if(slots.get(i).isFree()) {
				return slots.get(i);
			}
		}
		return null;
	}
}
