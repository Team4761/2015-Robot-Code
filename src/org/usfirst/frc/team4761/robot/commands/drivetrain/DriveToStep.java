package org.usfirst.frc.team4761.robot.commands.drivetrain;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drive the robot to the step.
 */
public class DriveToStep extends Command {
	MediumDistanceSensor distanceSensor = Robot.robotMap.outerConveyorToteDistanceSensor;
	GyroSensor gyro = new GyroSensor();
	
	public DriveToStep() {
		requires(Robot.driveTrain);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(1);
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.drive(0, -0.4, 0);
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	// Called once after isFinished returns true
	protected void end() {
		gyro.setDegrees(90);
		Robot.driveTrain.setAccumulator(90);
		Robot.driveTrain.gyroPidController.setSetpoint(90);
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
