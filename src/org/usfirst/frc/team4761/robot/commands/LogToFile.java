package org.usfirst.frc.team4761.robot.commands;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Log stuff to the console and a file.
 */
public class LogToFile extends Command {
	private double deltaTime = 0;
	private long begin = 0, end = 0;
	
	private GyroSensor gyro = new GyroSensor();
	private MediumDistanceSensor mediumDistanceSensor1 = RobotMap.mediumDistanceSensor1;
	private ShortDistanceSensor shortDistanceSensor1 = RobotMap.elevatorDistanceSensor;
	private Logger log = RobotMap.log;
	
	protected void initialize () {
		log.setLevel(Level.FATAL);
		setTimeout(1);
	}
	
	protected void execute () {
		begin = System.currentTimeMillis() % 1000;
		
		log.dev("Medium: " + Double.toString(mediumDistanceSensor1.getDistance()));
		log.dev("Short: " + Double.toString(shortDistanceSensor1.getDistance()));
		log.dev("Gyro: " + Double.toString(gyro.getDegrees(deltaTime)));
		
		deltaTime = (begin - end) / 1000.0;
		end = System.currentTimeMillis() % 1000;
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
