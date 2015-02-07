package org.usfirst.frc.team4761.robot.commands;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.DistanceSensor;
import org.usfirst.frc.team4761.robot.GyroSensor;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;

/**
*
*/
public class LogToFile extends Command {
	private DistanceSensor sensor = new DistanceSensor();
	private Logger log = RobotMap.log;
	
	protected void initialize () {
		log.setLevel(Level.FATAL);
	}
	
	protected void execute () {
		log.dev(Double.toString(sensor.getShortDistance()));
	}
	
	protected boolean isFinished () {
		return false;
	}
	protected void end () {
		
	}
	
	protected void interrupted () {
		end();
	}
}