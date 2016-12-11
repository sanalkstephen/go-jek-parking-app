package com.gojek.main;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import com.gojek.parkinglot.ParkingLot;


public class MainTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
//	 @Mock 
//	 ParkingLot parkingLot;
//     
//     @InjectMocks 
//     private ParkingApp parkingApp;
	
	
	@Before
	public void setStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
//	@Test
//	public void exitCommandTest() {
//		System.setIn(inExitContent);
//		Main.main(new String[0]);
//		assertEquals("bye", outContent.toString());
//	}
	
	@Test
	public void createParkingLotTest() {
		int slots = 10;
		ParkingLot lot = new ParkingLot(slots);
		assertEquals(slots, lot.getSlots().size());
	}
	
//	@Test
//	public void createCommandTest() {
//		int numSlots = 6;
//		String[] commandSplit = ("create_parking_lot " + numSlots + "").split(" ");
//		//when(parkingLot).thenReturn(new ParkingLot(numSlots));
//		//when(parkingApp).thenReturn(new ParkingApp());
//		parkingApp.runCommand(commandSplit[0], commandSplit);
//		assertEquals("Created a parking lot with " + numSlots +" slots", outContent.toString());
//		outContent.reset();
//	}
	
	@Test
	public void unKnownCommandTest() {
		ParkingApp app = new ParkingApp();
		app.runCommand("sjkdgvkjsd", null);
		assertTrue(outContent.toString().contains("Please try any of these commands: "));
		outContent.reset();
	}
}
	