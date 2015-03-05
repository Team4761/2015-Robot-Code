package org.usfirst.frc.team4761.robot.commands;

import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.MovingAverageCalculator;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Executes until the robot passes the back edge of a barrel.
 */
public class GoToBackEdgeOfBarrel extends Command {
	MediumDistanceSensor distanceSensor = RobotMap.barrelDistanceSensor;

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
    	if (distanceSensor.getDistance() > 60) {
    		System.out.println("On back edge");
    	}
    	
		return distanceSensor.getDistance() > 60;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
