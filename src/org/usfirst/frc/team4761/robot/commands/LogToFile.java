package org.usfirst.frc.team4761.robot.commands;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4761.robot.DistanceSensor;

/**
*
*/
public class LogToFile extends Command {
	private File file;
	private FileOutputStream outputStream;
	private BufferedWriter bw;
	
	private DistanceSensor sensor = new DistanceSensor();
	
	public LogToFile () {
		file = new File("/home/lvuser/tmp");
	}
	
	public LogToFile (File f){
		file = f;
	}
	
	protected void initialize () {
		try {
			outputStream = new FileOutputStream(file);
			bw = new BufferedWriter(new OutputStreamWriter(outputStream));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void execute () {
		double distance = sensor.getDistance();

		try {
			bw.write(System.nanoTime()+","+distance);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected boolean isFinished () {
		return false;
	}
	
	protected void end () {
		try {
			bw.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void interrupted() {
		end();
	}
}