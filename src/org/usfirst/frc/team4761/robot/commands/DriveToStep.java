package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * Drive the robot to the step.
 */
public class DriveToStep extends Command {
	private double deltaTime = 0;
	private long begin = 0, end = 0;
	
	ShortDistanceSensor distanceSensor = RobotMap.elevatorDistanceSensor;
	
	public DriveToStep() {
		requires(Robot.driveTrain);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		begin = System.currentTimeMillis() % 1000;
		
		Robot.driveTrain.drive(0.15, 0, deltaTime);
		
		deltaTime = (begin - end) / 1000.0;
		end = System.currentTimeMillis() % 1000;
		
		if (distanceSensor.getDistance() < 10) {
			setTimeout(0.5);
		}
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return distanceSensor.getDistance() < 10 && isTimedOut();
	}
	
	// Called once after isFinished returns true
	protected void end() {
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}