package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

/**
 *
 */
public class LogToFile extends Command {
	boolean button4 = true, button5 = true;
	
	//private DistanceSensor mediumDistanceSensor1 = new DistanceSensor(RobotMap.mediumDistanceSensor1);
	//private DistanceSensor shortDistanceSensor1 = new DistanceSensor(RobotMap.shortDistanceSensor1);
	private Logger log = RobotMap.log;
	
	protected void initialize() {
		log.setLevel(Level.FATAL);
	}
	
	protected void execute() {
		//log.dev("Medium: " + Double.toString(mediumDistanceSensor1.getShortDistance()));
		//log.dev("Short: " + Double.toString(shortDistanceSensor1.getShortDistance()));
		//log.dev("Gyro: " + Double.toString(GyroSensor.getDegrees()));

		if (Robot.oi.joystick1.getRawButton(4)) {
			button4 = !button4;
			if (!button4) {
				Robot.elevator.raise();
			} else {
				Robot.elevator.stop();
			}
		} else if (Robot.oi.joystick1.getRawButton(5)) {
			button5 = !button5;
			if (!button5) {
				Robot.elevator.lower();
			} else {
				Robot.elevator.stop();
			}
		}
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
