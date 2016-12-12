package com.gojek.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static ParkingApp parkingApp;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		parkingApp = new ParkingApp();
		BufferedReader br1 = null;
		FileWriter wr = null;
		if(args.length > 0) { 
			try {
				br1 =  new BufferedReader(new FileReader(new File("").getAbsolutePath() + "\\" + args[0]));
				String commandLine = null;
				String[] commandSplits = null;
				while((commandLine = br1.readLine()) != null) {
					commandSplits = commandLine.split(" ");
					String command = commandSplits[0];
					parkingApp.runCommand(command, commandSplits);
				}
				wr = new FileWriter(new File(new File("").getAbsolutePath() + "\\" + args[2]));
				//Writing the output to the specified file
				wr.write(parkingApp.getOutput());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(br1 !=null) br1.close();
					if(wr != null) wr.close();
				} catch (IOException e) {
				}
			}
		}
		else {
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String commandLine = null;
			String[] commandSplits = null;
			try {
				while(!(commandLine = br2.readLine()).equals("exit")) {
					commandSplits = commandLine.split(" ");
					String command = commandSplits[0];
					parkingApp.runCommand(command, commandSplits);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					br2.close();
				} catch (IOException e) {
				}
			}
			printOut("bye");
		}
	}
	
	
	
	public static void printOut(String message) {
		System.out.println(message);
	}

}
