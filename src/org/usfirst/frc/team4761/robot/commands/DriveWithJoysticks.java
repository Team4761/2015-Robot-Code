package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoysticks extends Command {
	private double deltaTime = 0;
	private long begin = 0, end = 0;
	
    public DriveWithJoysticks () {
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize () {
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute () {
    	begin = System.nanoTime();
    	Robot.driveTrain.driveWithJoysticks(Robot.oi.joystick1, Robot.oi.joystick2, deltaTime);
		deltaTime = (begin - end) / 1000000000.0;
		end = System.nanoTime();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished () {
        return false; // Run forever
    }

    // Called once after isFinished returns true
    protected void end () {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted () {
    	end();
    }
}
