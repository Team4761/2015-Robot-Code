package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

/**
 * A command that spins the {@link org.usfirst.frc.team4761.robot.subsystems.RcGrabberBase Barrel Grabber Base} outwards and
 * gets stopped by a limit switch or a timeout if the limit switch isn't reached.
 */

public class SpinRcBaseOut extends Command {
	public SpinRcBaseOut() {
		requires(Robot.rcGrabberBase);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(5); // If not done by the time 
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.rcGrabberBase.spinnerSet(0.5);
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Robot.rcGrabberBase.outTriggered() || isTimedOut());
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.rcGrabberBase.spinnerSet(0.0);
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
