package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * If the distance sensor on the elevator is below the top of a stack of totes,
 * move the elevator up until it is level with the top of the stack.
 */
public class MoveElevatorUpToStackTop extends Command {
	
	ShortDistanceSensor ds = RobotMap.elevatorDistanceSensor;
	Double distance = 20.0;
	
	// Called just before this Command runs the first time
	protected void initialize() {
		requires(Robot.elevator);
		
		if (ds.getDistance() > distance) {
			this.cancel(); // Elevator is already above stack top
		}
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevator.raise();
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return ds.getDistance() > distance; // Stop running when past last tote in stack
	}
	
	// Called once after isFinished returns true
	protected void end() {
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
