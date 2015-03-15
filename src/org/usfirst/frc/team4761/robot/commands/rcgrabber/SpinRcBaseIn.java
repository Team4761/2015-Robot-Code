package org.usfirst.frc.team4761.robot.commands.rcgrabber;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command that spins the {@link org.usfirst.frc.team4761.robot.subsystems.RcGrabberBase Barrel Grabber Base} inwards and
 * gets stopped by a limit switch or a timeout if the limit switch isn't reached.
 */

public class SpinRcBaseIn extends Command {
	public SpinRcBaseIn() {
		requires(Robot.rcGrabberBase);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.rcGrabberBase.goIn();
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.rcGrabberBase.inTriggered();
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.rcGrabberBase.stop();
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
