package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * Just waits until a barrel is found
 */
public class CheckForBarrel extends Command {
	ShortDistanceSensor distanceSensor = RobotMap.barrelSensor;
	double distance;
	int disregardCount = 0;
	public CheckForBarrel() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}
	
	protected void initialize() {
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		if(disregardCount >= 10) {
			distance = distanceSensor.getDistance();
			if(distance < 250) {
				return true;
			}
		}
		else {
			disregardCount++;
		}
		return false;
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}
}
