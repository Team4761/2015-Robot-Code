package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * A command to utilize logging with simon's {@link org.simonandrews.robolog robolog library}.
 */
public class LogToFile extends Command {
	
	//private DistanceSensor mediumDistanceSensor1 = new DistanceSensor(RobotMap.mediumDistanceSensor1);
	private ShortDistanceSensor shortDistanceSensor1 = RobotMap.barrelDistanceSensor;
	private Logger log = RobotMap.log;
	
	protected void initialize() {
		log.setLevel(Level.FATAL);
	}
	
	protected void execute() {
		//log.dev("Medium: " + Double.toString(mediumDistanceSensor1.getShortDistance()));
		//log.dev("Short: " + Double.toString(shortDistanceSensor1.getDistance()));
		//log.dev("Gyro: " + Double.toString(GyroSensor.getDegrees()));
		//System.out.println(!RobotMap.elevatorDI.get());
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		end();
	}
}
