package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * A command to utilize logging with simon's {@link org.simonandrews.robolog robolog library}.
 */
public class LogToFile extends Command {
	
	private ShortDistanceSensor elevatorBarrelDistanceSensor = RobotMap.outerConveyorFrontDistanceSensor;
	private MediumDistanceSensor outerConveyorToteDistanceSensor = RobotMap.outerConveyorToteDistanceSensor;
	private MediumDistanceSensor barrelSensor = RobotMap.barrelDistanceSensor;
	private Logger log = RobotMap.log;
	
	protected void initialize() {
		log.setLevel(Level.FATAL);
	}
	
	protected void execute() {
		//log.dev("Towards Conveyor: " + Double.toString(elevatorBarrelDistanceSensor.getDistance()));
		//log.dev("Towards Totes: " + Double.toString(outerConveyorToteDistanceSensor.getDistance()));
		//log.dev("Gyro: " + Double.toString(GyroSensor.getDegrees()));
		log.dev(Double.toString(barrelSensor.getDistance()) + " " + Double.toString(barrelSensor.getVoltage()));
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
