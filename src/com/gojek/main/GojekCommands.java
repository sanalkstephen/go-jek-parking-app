package com.gojek.main;

public enum GojekCommands {
	create_parking_lot, park, leave, status, 
	registration_numbers_for_cars_with_colour, 
	slot_numbers_for_cars_with_colour,
	slot_number_for_registration_number;
	
	public static String valuesToString() {
		return "create_parking_lot, park, leave, status, " +
	    "registration_numbers_for_cars_with_colour, " + 
		"slot_numbers_for_cars_with_colour, " +
	    "slot_number_for_registration_number";
	}
}
