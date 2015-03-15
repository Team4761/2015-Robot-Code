package org.usfirst.frc.team4761.robot.commands.elevator;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 * If the distance sensor on the elevator is below the top of a stack of totes,
 * move the elevator up until it is level with the top of the stack.
 */
public class MoveElevatorToStackTop extends Command {
	MediumDistanceSensor sensor = RobotMap.outerConveyorToteDistanceSensor;
	private boolean passedStack = false;
	
	public MoveElevatorToStackTop() {
		requires(Robot.elevator);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (sensor.getDistance() > 80 && !passedStack) {
			passedStack = true;
		}
		if (passedStack) {
			Robot.elevator.lower();
		} else {
			Robot.elevator.raise();
		}
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return sensor.getDistance() < 80 && passedStack; // Stop running when past last tote in stack
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
