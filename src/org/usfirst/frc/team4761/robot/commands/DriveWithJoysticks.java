package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

/**
 * Drive the robot around, using joysticks to control it.
 */
public class DriveWithJoysticks extends Command {
	
	public DriveWithJoysticks() {
		//requires(Robot.driveTrain);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.driveWithJoysticks(Robot.oi.joysticks[0], Robot.oi.joysticks[1]);
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false; // Run forever
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
