package org.usfirst.frc.team4761.robot.buttons;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

public class MainConveyorForward extends Command {
	
	public MainConveyorForward() {
		requires(Robot.mainConveyorBelt);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(0.02);
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.mainConveyorBelt.go(0.5);
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.mainConveyorBelt.go(0);
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
