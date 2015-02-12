package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

/**
 *
 */
public class DriveAlongStep extends Command {
	private double deltaTime = 0;
	private long begin = 0, end = 0;
	
	public DriveAlongStep() {
		requires(Robot.driveTrain);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		begin = System.currentTimeMillis() % 1000;

		Robot.driveTrain.drive(0.15, -0.15, 0, deltaTime); // Update for higher speed
		
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
