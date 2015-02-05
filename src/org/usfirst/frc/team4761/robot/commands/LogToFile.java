package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.simonandews.robolog.Logger;
import org.usfirst.frc.team4761.robot.DistanceSensor;
import org.usfirst.frc.team4761.robot.RobotMap;

/**
*
*/
public class LogToFile extends Command {	
	private DistanceSensor sensor = new DistanceSensor();
	private Logger log = RobotMap.log;
	
	protected void initialize () {
	}
	
	protected void execute () {
		log.dev(Double.toString(sensor.getDistance()));
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