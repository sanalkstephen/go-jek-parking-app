package com.gojek.parkinglot;

import com.gojek.vehicle.IVehicle;

public class Slot {
	
	private int serialNum;
	
	private IVehicle parkedVehicle;
	
	private boolean bEmpty;
	
	/**
	 * Create a slot with given serial Number
	 * @param serialNum
	 */
	public Slot(int serialNum) {
		this.serialNum = serialNum;
		this.bEmpty = true;
	}
	
	/**
	 * Park the vehicle 
	 * @param vehicleToPark
	 */
	public void parkVehicle(IVehicle vehicleToPark) {
		parkedVehicle = vehicleToPark;
		bEmpty = false;
	}
	
	public IVehicle getParkedVehicle() {
		return parkedVehicle;
	}
	
	public int getSerialNumber() {
		return serialNum;
	}
	
	public boolean isFree() {
		return bEmpty;
	}
	
	/**
	 * Make the slot free 
	 * @return
	 */
	public boolean setFree() {
		bEmpty = true;
		parkedVehicle = null;
		return bEmpty;
	}

}
