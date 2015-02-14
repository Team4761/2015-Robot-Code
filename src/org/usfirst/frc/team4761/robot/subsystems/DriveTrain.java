package org.usfirst.frc.team4761.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4761.robot.DrivePIDOutput;
import org.usfirst.frc.team4761.robot.GyroPIDSource;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

/**
 * Base of the robot with wheels attached to it.
 */
public class DriveTrain extends Subsystem {
	public double rotateAccumulator = 0; // Where the robot wants to be based on all of the accumulated values of the joystick
	
	RobotDrive robotDrive = RobotMap.robotDrive;
	
	GyroPIDSource gyroSensor = new GyroPIDSource();
	
	DrivePIDOutput driveGyroPIDOutput = new DrivePIDOutput();
	
	public PIDController gyroPidController = new PIDController(0.01, 0.00025, 0.065, gyroSensor, driveGyroPIDOutput); // (P, I, D, input, output)
	
	public DriveTrain () {
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		
		gyroPidController.enable();
		
		gyroPidController.setSetpoint(0);
	}
	
	public void initDefaultCommand () {}
	
	/**
	 * Drive the robot. Basically a fancy wrapper around mecanumDrive_Cartesian
	 * but with some special features.
	 * @param x Power for moving on x-axis
	 * @param y Power for moving on y-axis
	 * @param rotate Rotation of the robot
	 */
	public void drive(double x, double y, double rotate) {
		rotateAccumulator += rotate;
		gyroPidController.setSetpoint(rotateAccumulator);
		
		robotDrive.mecanumDrive_Cartesian(x, y, driveGyroPIDOutput.getValue(), GyroSensor.getDegrees());
	}
	
	public void stop () {
		robotDrive.drive(0, 0);
	}
	
	// Get z-axis and scale it
	private double getZ (Joystick joystick) {
		return (-0.3 * joystick.getZ() + 0.5);
	}
	
	// Calculate new speed based on the scaled z-axis
	private double convert (double input, Joystick joystick) {
		return (input * getZ(joystick));
	}
	
	public void driveWithJoysticks (Joystick joystick1, Joystick joystick2) {
		double degrees = GyroSensor.getDegrees();
		
		System.out.println("Angle: " + degrees + " Accumulator: " + rotateAccumulator + " DrivePIDOutput: " + convert(driveGyroPIDOutput.getValue(), joystick1));
		
		// This button is too heavily integrated with DriveTrain to use ButtonManager.java
		if (!(joystick2.getRawButton(2))) { // Hold down button two when sliding against walls
			double joystickChange = convert(joystick1.getX(), joystick1) * 3.5;
			if (Math.abs(joystickChange) > 0.05) { // Filter out noise
				rotateAccumulator += joystickChange;
			}
			
			gyroPidController.setSetpoint(rotateAccumulator);
			
			robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), driveGyroPIDOutput.getValue(), degrees);
		} else {
			robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), 0, degrees);
			
			rotateAccumulator = GyroSensor.getDegrees(); // Reset the accumulator so the robot doesn't jerk when button two is released
		}
	}
}
