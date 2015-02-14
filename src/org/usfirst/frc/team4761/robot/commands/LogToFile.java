package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

/**
 *
 */
public class LogToFile extends Command {
	private double deltaTime = 0;
	private long begin = 0, end = 0;
	
	//private DistanceSensor mediumDistanceSensor1 = new DistanceSensor(RobotMap.mediumDistanceSensor1);
	//private DistanceSensor shortDistanceSensor1 = new DistanceSensor(RobotMap.shortDistanceSensor1);
	private Logger log = RobotMap.log;
	
	protected void initialize() {
		log.setLevel(Level.FATAL);
		setTimeout(1);
	}
	
	protected void execute() {
		begin = System.currentTimeMillis() % 1000;
		
		//log.dev("Medium: " + Double.toString(mediumDistanceSensor1.getShortDistance()));
		//log.dev("Short: " + Double.toString(shortDistanceSensor1.getShortDistance()));
		log.dev("Gyro: " + Double.toString(GyroSensor.getDegrees()));
		
		deltaTime = (begin - end) / 1000.0;
		end = System.currentTimeMillis() % 1000;
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
