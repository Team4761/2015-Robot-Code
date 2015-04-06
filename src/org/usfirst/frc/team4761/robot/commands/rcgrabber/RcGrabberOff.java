package org.usfirst.frc.team4761.robot.commands.rcgrabber;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Turn off the pneumatics of the {@link org.usfirst.frc.team4761.robot.subsystems.Plow plow}.
 * @author mathias
 */

public class RcGrabberOff extends Command {
	
	public RcGrabberOff() {
		requires(Robot.rcGrabber);
	}
	
	protected void initialize() {
		setTimeout(1);
		Robot.rcGrabber.set(DoubleSolenoid.Value.kOff);
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
