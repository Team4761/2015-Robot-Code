package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

/**
 * Drive along the step
 */
public class DriveAlongStep extends Command {
	private static int detectedBarrelCount = 0;
	public DriveAlongStep() {
		requires(Robot.driveTrain);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(7.5);
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.drive(0.15, -0.15, 0); // Update for higher speed
		if(RobotMap.barrelDistanceSensor.getDistance() < 40) {
			detectedBarrelCount++;
		}
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return detectedBarrelCount == 2;
	}
	
	// Called once after isFinished returns true
	protected void end() {
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
