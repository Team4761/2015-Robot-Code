package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.MovingAverageCalculator;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that does nothing and runs until an object has entered and exited
 * the field of view of the outer conveyor belt's rear distance sensor. Useful
 * if the driver needs to position an RC on the lower distance sensor, but can
 * not see and does not want to risk dropping the object.
 */
public class BlindStopOuterConveyorBelt extends Command {

    private double distance;
	private MovingAverageCalculator mac = new MovingAverageCalculator(10);
	private boolean objectEntered;
	MediumDistanceSensor distanceSensor = Robot.robotMap.outerConveyorToteDistanceSensor;

	public BlindStopOuterConveyorBelt() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	distance = distanceSensor.getDistance();
    	mac.add(distance);
    	if(mac.getAverage() < 40 && objectEntered == false) {
    		objectEntered = true;
    	}
    	if(objectEntered) {
    		if(mac.getAverage() > 40) {
    			return true;
    		}
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
