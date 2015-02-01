package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.DistanceSensor;
import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GetDistance extends Command {
	public static boolean onDistance = false;
	
	DistanceSensor distanceSensor = new DistanceSensor();

    public GetDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1); // Ignore weird first values
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.driveTrain.drive(0.15, 0.15, 0);
    	
    	if (isTimedOut()) {
	    	double distance = distanceSensor.getDistance();
	    	
	    	if (distance < 30) {
	    		System.out.println("Barrel at: " + distance);
	    		onDistance = true;
	    	} else {
	    		System.out.println(distance);
	    	}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return onDistance;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	onDistance = true;
    }
}
