package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Resets the gyro position to 90 degrees.
 */
public class ResetGyro extends Command {
	static int degrees;
	public ResetGyro(int degrees) {
		this.degrees = degrees;
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// Blue Gyro
		/*RobotMap.gyro.gyroSensor.reset();
		RobotMap.gyro.setOffset(degrees);*/
		// I2C Gyro
		RobotMap.gyro.setDegrees(degrees);
		Robot.driveTrain.setAccumulator(degrees);
		Robot.driveTrain.gyroPidController.setSetpoint(degrees);
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
