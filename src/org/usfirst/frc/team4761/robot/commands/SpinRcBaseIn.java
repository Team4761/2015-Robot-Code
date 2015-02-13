package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

public class SpinRcBaseIn extends Command {
	public SpinRcBaseIn() {
		requires(Robot.rcGrabberBase);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.rcGrabberBase.spinnerSet(0.3);
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.rcGrabberBase.inTriggered();
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.rcGrabberBase.spinnerSet(0.0);
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
