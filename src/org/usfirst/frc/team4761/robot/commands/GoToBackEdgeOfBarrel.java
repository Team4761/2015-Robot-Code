package org.usfirst.frc.team4761.robot.commands;

import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.MovingAverageCalculator;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToBackEdgeOfBarrel extends Command {
	MediumDistanceSensor distanceSensor = RobotMap.barrelDistanceSensor;
	double distance;
	int disregardCount = 0;
	Logger log = new Logger("Go Back Edge of Barrel");
	MovingAverageCalculator mac = new MovingAverageCalculator(10);
    public GoToBackEdgeOfBarrel() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*if (disregardCount >= 3) {
			distance = distanceSensor.getDistance();
			mac.add(distance);
			if (mac.getAverage() > 30) {
				log.info("At back edge of barrel! Ending...");
			}
		} else {
			log.info("Not paying attention yet...");
			disregardCount++;
		}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (distanceSensor.getDistance() > 50) {
    		System.out.println("On back edge");
    	}
		return distanceSensor.getDistance() > 50;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
