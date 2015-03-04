package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the robot forward until a barrel is detected.
 */
public class GoToNextBarrel extends Command {
	MediumDistanceSensor distanceSensor = Robot.robotMap.barrelDistanceSensor;
	
	public GoToNextBarrel() {
	}
	
	protected void initialize() {
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		if (distanceSensor.getDistance() < 60) {
			System.out.println("On front edge");
		}
		
		return distanceSensor.getDistance() < 60;
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}
}
