package org.usfirst.frc.team4761.robot.commands;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.DistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
*
*/
public class LogToFile extends Command {
	private DistanceSensor mediumDistanceSensor1 = new DistanceSensor(RobotMap.mediumDistanceSensor1);
	private DistanceSensor shortDistanceSensor1 = new DistanceSensor(RobotMap.shortDistanceSensor1);
	private Logger log = RobotMap.log;
	
	protected void initialize () {
		log.setLevel(Level.FATAL);
	}
	
	protected void execute () {
		log.dev("Medium: " + Double.toString(mediumDistanceSensor1.getShortDistance()));
		log.dev("Short: " + Double.toString(shortDistanceSensor1.getShortDistance()));
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