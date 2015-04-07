package org.usfirst.frc.team4761.robot.commands.rcgrabber;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 * A command to lower the RcGrabber pneumatics in the {@link org.usfirst.frc.team4761.robot.subsystem.RcGrabber RcGrabber}.
 * @author mathias
 */
public class RcGrabberDown extends Command {
	
	public RcGrabberDown() {
		requires(Robot.rcGrabber);
	}
	
	protected void initialize() {
		setTimeout(1);
		Robot.rcGrabber.set(DoubleSolenoid.Value.kForward);
	}
	
	protected void execute() {
	}
	
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}
}