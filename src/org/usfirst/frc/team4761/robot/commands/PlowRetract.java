package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

public class PlowRetract extends Command {
	
	public PlowRetract() {
		requires(Robot.plower);
	}
	
	protected void initialize() {
		setTimeout(1);
	}
	
	protected void execute() {
		Robot.plower.set(DoubleSolenoid.Value.kReverse);
	}
	
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}
}
