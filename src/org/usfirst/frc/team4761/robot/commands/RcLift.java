package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

public class RcLift extends Command {
	
	DoubleSolenoid solenoid = Robot.rcGrabber.solenoid;
	
	public RcLift() {
		requires(Robot.rcGrabber);
	}
	
	protected void initialize() {
		setTimeout(1);
	}
	
	protected void execute() {
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}
}
