package org.usfirst.frc.team4761.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;

/**
 * If the distance sensor on the elevator is below the top of a stack of totes,
 * move the elevator up until it is level with the top of the stack.
 */
public class MoveElevatorToStackTop extends Command {
	MediumDistanceSensor sensor = RobotMap.outerConveyorToteDistanceSensor;
	
	public MoveElevatorToStackTop() {
		requires(Robot.elevator);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevator.raise();
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return sensor.getDistance() > 80; // Stop running when past last tote in stack
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
