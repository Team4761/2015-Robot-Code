package org.usfirst.frc.team4761.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.DrivePIDOutput;
import org.usfirst.frc.team4761.robot.GyroPIDSource;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

/**
 * Base of the robot with wheels attached to it.
 */
public class DriveTrain extends Subsystem {
	public double rotateAccumulator = 0; // Where the robot wants to be based on all of the accumulated values of the joystick
	
	private Logger log = RobotMap.log;
	RobotDrive robotDrive = RobotMap.robotDrive;
	GyroPIDSource gyroSensor = new GyroPIDSource();
	public DrivePIDOutput driveGyroPIDOutput = new DrivePIDOutput();
	
	public PIDController gyroPidController = new PIDController(0.05, 0.00025, 0, gyroSensor, driveGyroPIDOutput); // (P, I, D, input, output)
	
	public DriveTrain () {
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		
		gyroPidController.enable();
	}
	
	public void initDefaultCommand () {}
	
	/**
	 * Drive the robot. Basically a fancy wrapper around mecanumDrive_Cartesian
	 * but with some special features.
	 * @param x Power for moving on x-axis
	 * @param y Power for moving on y-axis
	 * @param rotate Rotation of the robot
	 */
	public void drive (double x, double y, double rotate) {
		rotateAccumulator += rotate;
		gyroPidController.setSetpoint(rotateAccumulator);
		
		robotDrive.mecanumDrive_Cartesian(x, y, driveGyroPIDOutput.getValue(), GyroSensor.getDegrees());
		//robotDrive.mecanumDrive_Cartesian(x, y, 0, GyroSensor.getDegrees());
	}
	
	public void driveAbsolute (double x, double y, double degrees) {
		gyroPidController.setSetpoint(degrees);
		
		robotDrive.mecanumDrive_Cartesian(x, y, driveGyroPIDOutput.getValue(), 90);
		//robotDrive.mecanumDrive_Cartesian(x, y, 0, GyroSensor.getDegrees());
	}
	
	public void driveNoField (Joystick joystick1, Joystick joystick2) {
		System.out.println("Not field oriented");
		robotDrive.mecanumDrive_Cartesian(convert(Robot.oi.joysticks[2].getRawAxis(0), joystick2), convert(Robot.oi.joysticks[2].getRawAxis(1), joystick2), convert(Robot.oi.joysticks[2].getRawAxis(4), joystick1), 0);
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
		
		log.dev("Angle: " + degrees);

		//robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), convert(joystick1.getX(), joystick1), degrees);
		robotDrive.mecanumDrive_Cartesian(convert(Robot.oi.joysticks[2].getRawAxis(0), joystick2), convert(Robot.oi.joysticks[2].getRawAxis(1), joystick2), convert(Robot.oi.joysticks[2].getRawAxis(4), joystick1), degrees);
	}
	
	public void setAccumulator (double degrees) {
		rotateAccumulator = degrees;
	}
}
