package org.usfirst.frc.team4761.robot.commands;

import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToBackEdgeOfBarrel extends Command {
	ShortDistanceSensor distanceSensor = RobotMap.barrelDistanceSensor;
	double distance;
	int disregardCount = 0;
	Logger log = new Logger("Go Back Edge of Barrel");
    public GoToBackEdgeOfBarrel() {
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		if (disregardCount >= 3) {
			distance = distanceSensor.getDistance();
			if (distance > 260) {
				log.info("At back edge of barrel! Ending...");
				return true;
			}
		} else {
			log.info("Not paying attention yet...");
			disregardCount++;
		}
		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
