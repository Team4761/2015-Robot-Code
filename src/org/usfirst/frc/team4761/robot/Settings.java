package org.usfirst.frc.team4761.robot;

import java.io.*;
import java.util.Scanner;

/**
 * Reads and loads configuration settings from/to a file on the Robot.
 */
public class Settings  {
	
	/**
	 * Reads a setting from the config file.
	 * @param name the name of the setting to read
	 * @return the value of the setting
	 */
	public static int read (String name) {
		try {
			File f = new File("/home/lvuser/settings.ini");
			Scanner sc = new Scanner(new FileInputStream(f));
			String inp = sc.nextLine();
			
			while (inp != null) {
				if (inp.split("\t")[0].equalsIgnoreCase(name)) {
					sc.close();
					return Integer.parseInt(inp.split("\t")[1]);
				}
				
				inp = sc.nextLine();
			}
			sc.close();
		} catch (Exception ex) {
			System.err.println("Error loading setting \"" + name + "\".");
			ex.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * Writes a setting out to the config file.
	 * @param name the name of the setting to write
	 * @param value the value of the setting to write
	 */
	public static void write (String name, int value) {
		File f = new File("/home/lvuser/settings.ini");
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			
			PrintWriter out = new PrintWriter(new FileOutputStream(f));
			out.println(name + "\t" + value);
			out.close();
		} catch (Exception ex) {
			System.err.println("Error writing setting \"" + name + "\" to the config file.");
		}
	}
}
