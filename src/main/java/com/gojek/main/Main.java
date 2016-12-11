package com.gojek.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static ParkingApp parkingApp;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		parkingApp = new ParkingApp();
		if(args.length > 0) {
			
		}
		else {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String commandLine = null;
			String[] commandSplits = null;
			try {
				while(!(commandLine = br.readLine()).equals("exit")) {
					commandSplits = commandLine.split(" ");
					String command = commandSplits[0];
					parkingApp.runCommand(command, commandSplits);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			printOut("bye");
		}
	}
	
	
	
	public static void printOut(String message) {
		System.out.println(message);
	}

}
