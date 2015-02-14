package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * Moves the robot forward until a barrel is detected.
 */
public class GoToNextBarrel extends Command {
	ShortDistanceSensor distanceSensor = RobotMap.barrelDistanceSensor;
	double distance;
	int disregardCount = 0;
	public GoToNextBarrel() {
		requires(Robot.driveTrain);
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
