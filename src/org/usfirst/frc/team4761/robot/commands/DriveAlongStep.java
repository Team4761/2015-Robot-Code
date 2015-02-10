package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.DistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAlongStep extends Command {
	private double deltaTime = 0;
	private long begin = 0, end = 0;
	private boolean forward = true;

    public DriveAlongStep (boolean forward) {
    	this.forward = forward;
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	begin = System.currentTimeMillis() % 1000;
		
    	if (forward) {
    		Robot.driveTrain.drive(0.15, 0.15, 0, deltaTime); // Update for higher speed
    	} else {
    		Robot.driveTrain.drive(0.15, -0.15, 0, deltaTime); // Update for higher speed
    	}

		deltaTime = (begin - end) / 1000.0;
		end = System.currentTimeMillis() % 1000;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
