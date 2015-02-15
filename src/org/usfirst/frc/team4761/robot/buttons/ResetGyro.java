package org.usfirst.frc.team4761.robot.buttons;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

/**
 *
 */
public class ResetGyro extends Command {
	GyroSensor gyro = new GyroSensor();
	
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
		System.out.println("Test1");
		gyro.setDegrees(-90);
		System.out.println("Test1");
		Robot.driveTrain.setAccumulator(-90);
		System.out.println("Test1");
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
