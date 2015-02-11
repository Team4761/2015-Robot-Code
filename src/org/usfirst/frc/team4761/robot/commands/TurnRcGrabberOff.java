package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

public class TurnRcGrabberOff extends Command {
	
	DoubleSolenoid solenoid = Robot.rcGrabber.solenoid;
	
	public TurnRcGrabberOff() {
		requires(Robot.rcGrabber);
	}
	
	protected void initialize() {
		setTimeout(1);
	}
	
	protected void execute() {
		Robot.rcGrabber.set(DoubleSolenoid.Value.kOff);
	}
	
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}
}
