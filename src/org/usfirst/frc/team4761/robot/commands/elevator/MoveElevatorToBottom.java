package org.usfirst.frc.team4761.robot.commands.elevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

/**
 * Move {@link org.usfirst.frc.team4761.robot.subsystems.Elevator Elevator} down.
 */
public class MoveElevatorToBottom extends Command {
	DigitalInput di = Robot.robotMap.elevatorDI;
	
	public MoveElevatorToBottom() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.elevator);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevator.lower();
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return !di.get();
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.elevator.stop();
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
