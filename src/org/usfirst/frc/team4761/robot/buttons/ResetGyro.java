package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

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
		// Blue Gyro
		/*RobotMap.gyro.gyroSensor.reset();
		RobotMap.gyro.setOffset(90);*/
		// I2C Gyro
		RobotMap.gyro.setDegrees(90);
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
