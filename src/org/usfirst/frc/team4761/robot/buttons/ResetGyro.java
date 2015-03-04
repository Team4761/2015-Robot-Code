package org.usfirst.frc.team4761.robot.buttons;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

/**
 * Resets the gyro position to 90 degrees.
 */
public class ResetGyro extends Command {
	
	public ResetGyro() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// Needs to be tested to find appropriate value
		Robot.robotMap.gyro.gyroSensor.reset();
		Robot.robotMap.gyro.setOffset(90);
		Robot.driveTrain.setAccumulator(90);
		Robot.driveTrain.gyroPidController.setSetpoint(90);
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}
	
	// Called once after isFinished returns true
	protected void end() {
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
