package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

/**
 * Drive along the step
 */
public class DriveAlongStep extends Command {
	
	public DriveAlongStep() {
		requires(Robot.driveTrain);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.drive(0.15, -0.15, 0); // Update for higher speed
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false; //TODO: stop at some point
	}
	
	// Called once after isFinished returns true
	protected void end() {
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
