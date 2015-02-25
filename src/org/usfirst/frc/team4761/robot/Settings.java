package org.usfirst.frc.team4761.robot;

import java.io.*;
import java.util.Scanner;

public class Settings  {
	public static int read(String name) {
		try {
			File f = new File("settings.ini");
			Scanner sc = new Scanner(new FileInputStream(f));
			String inp = sc.nextLine();
			while (inp!=null)
			{
				if (inp.split("\t")[0].equalsIgnoreCase(name))
				{
					sc.close();
					return Integer.parseInt(inp.split("\t")[1]);
				}
				inp = sc.nextLine();
			}
		} catch (Exception ex) {
			System.err.println("Error loading setting \"" + name + "\".");
		}
		return 0;
	}
	
	public static void write(String name, int value) {
		File f = new File("settings.ini");
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(f));
			out.println(name + "\t" + value);
			out.close();
		} catch (Exception ex) {
			System.err.println("Error writing setting \"" + name + "\" to the config file.");
		}
	}
}
