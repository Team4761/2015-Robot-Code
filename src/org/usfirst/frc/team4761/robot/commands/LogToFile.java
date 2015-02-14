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
	
	private ShortDistanceSensor elevatorToteDistanceSensor = RobotMap.elevatorToteDistanceSensor;
	private ShortDistanceSensor elevatorBarrelDistanceSensor = RobotMap.elevatorBarrelDistanceSensor;
	private Logger log = RobotMap.log;
	
	protected void initialize() {
		log.setLevel(Level.FATAL);
	}
	
	protected void execute() {
		log.dev("Towards Conveyor: " + Double.toString(elevatorToteDistanceSensor.getDistance()));
		log.dev("Towards Totes: " + Double.toString(elevatorBarrelDistanceSensor.getDistance()));
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
