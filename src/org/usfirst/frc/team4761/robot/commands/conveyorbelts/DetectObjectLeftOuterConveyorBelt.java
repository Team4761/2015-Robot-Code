package org.usfirst.frc.team4761.robot.commands.conveyorbelts;

import org.usfirst.frc.team4761.robot.MovingAverageCalculator;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that does nothing and runs until it detects that an object has gone
 * on and gotten off the outer conveyor belt.
 */
public class DetectObjectLeftOuterConveyorBelt extends Command {
	MovingAverageCalculator mac = new MovingAverageCalculator(15);
	ShortDistanceSensor distanceSensor = Robot.robotMap.outerConveyorBarrelDistanceSensor;
	private double distance;
	private boolean objectEntered;
    public DetectObjectLeftOuterConveyorBelt() {
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
