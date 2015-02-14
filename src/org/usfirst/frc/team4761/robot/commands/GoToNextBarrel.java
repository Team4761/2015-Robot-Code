package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.MovingAverageCalculator;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * Moves the robot forward until a barrel is detected.
 */
public class GoToNextBarrel extends Command {
	ShortDistanceSensor distanceSensor = RobotMap.barrelDistanceSensor;
	double distance;
	int disregardCount = 0;
	Logger log = new Logger("Go To Next Barrel");
	MovingAverageCalculator mac = new MovingAverageCalculator(10);
	public GoToNextBarrel() {
	}
	
	protected void initialize() {
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		if (disregardCount >= 5) {
			distance = distanceSensor.getDistance();
			mac.add(distance);
			if (mac.getAverage() < 40) {
				log.info("At barrel! Ending...");
				return true;
			}
		} else {
			log.info("Not paying attention yet...");
			disregardCount++;
		}
		return false;
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}
}
