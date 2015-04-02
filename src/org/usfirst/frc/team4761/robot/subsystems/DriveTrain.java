package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.DistancePIDSource;
import org.usfirst.frc.team4761.robot.DrivePIDOutput;
import org.usfirst.frc.team4761.robot.GyroPIDSource;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Base of the robot with wheels attached to it.
 */
public class DriveTrain extends Subsystem {
	public double rotateAccumulator = 0; // Where the robot wants to be based on all of the accumulated values of the joystick
	
	public RobotDrive robotDrive = RobotMap.robotDrive;
	public GyroPIDSource gyroSensor = new GyroPIDSource();
	public DrivePIDOutput driveGyroPIDOutput = new DrivePIDOutput();
	public PIDController gyroPidController = new PIDController(0.03, 0, 0, gyroSensor, driveGyroPIDOutput);
	
	public DrivePIDOutput driveDistancePIDOutput = new DrivePIDOutput();
	public DistancePIDSource distanceSensor = new DistancePIDSource(RobotMap.wallDistanceSensor);
	public PIDController distancePidController = new PIDController(0.325, 0.00005, 5, distanceSensor, driveDistancePIDOutput);
	
	public DriveTrain () {
		if (RobotMap.robot == 1) {
			robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
			robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		}
		
		gyroPidController.setSetpoint(0);
		gyroPidController.enable();
		
		distancePidController.setSetpoint(3);
		distancePidController.enable();
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
	}
	
	public void driveAbsolute (double x, double y, double degrees) {
		gyroPidController.setSetpoint(degrees);
		
		robotDrive.mecanumDrive_Cartesian(x, y, degrees, 90);
	}
	
	public void stop () {
		robotDrive.drive(0, 0);
	}
	
	// Get z-axis and scale it
	private double useEquation (double axis) {
		return (0.3 * (axis * 10) + 0.5);
	}
	
	// Calculate new speed based on the scaled z-axis
	private double convert (double input, double axis, double override) {
		if (override != 0) {
			return (input * useEquation(axis)) * override;
		}
		return (input * useEquation(axis));
	}
	
	public void driveWithJoysticks () {
		double degrees = GyroSensor.getDegrees();
		
		// Used for testing PID for autonomous
		/*if (convert(Robot.oi.joysticks[0].getRawAxis(4), Robot.oi.joysticks[2].getRawAxis(1), 0) > 0.075 || convert(Robot.oi.joysticks[0].getRawAxis(4), Robot.oi.joysticks[2].getRawAxis(1), 0) < -0.075) {
			rotateAccumulator += convert(Robot.oi.joysticks[0].getRawAxis(4), Robot.oi.joysticks[2].getRawAxis(1), 0) * 3;
		}
		
		gyroPidController.setSetpoint(rotateAccumulator);
		gyroPidController.setPID(SmartDashboard.getNumber("P"), SmartDashboard.getNumber("I"), SmartDashboard.getNumber("D"));
		robotDrive.mecanumDrive_Cartesian(convert(Robot.oi.joysticks[0].getRawAxis(0), Robot.oi.joysticks[2].getRawAxis(0), 0), convert(Robot.oi.joysticks[0].getRawAxis(1), Robot.oi.joysticks[2].getRawAxis(0), 0), driveGyroPIDOutput.getValue(), degrees);*/
		
		//System.out.println("Driving At: " + convert(Robot.oi.joysticks[0].getRawAxis(0), Robot.oi.joysticks[2].getRawAxis(0), Math.abs(driveDistancePIDOutput.getValue())));
		//System.out.println("PID Returns: " + Math.abs(driveDistancePIDOutput.getValue()));
		
		//distancePidController.setPID(SmartDashboard.getNumber("P"), SmartDashboard.getNumber("I"), SmartDashboard.getNumber("D"));
		
		SmartDashboard.putNumber("Joystick: ", Robot.oi.joysticks[0].getRawAxis(1));
		SmartDashboard.putNumber("PID: ", driveDistancePIDOutput.getValue());
		SmartDashboard.putNumber("Send to Wheels: ", convert(Robot.oi.joysticks[0].getRawAxis(1), Robot.oi.joysticks[2].getRawAxis(0), -driveDistancePIDOutput.getValue()));
		
		if (RobotMap.robot == 1) {
			if (!Robot.oi.joysticks[0].getRawButton(6)) {
				if (Robot.oi.joysticks[0].getRawButton(5)) {
					//robotDrive.mecanumDrive_Cartesian(convert(Robot.oi.joysticks[0].getRawAxis(0), Robot.oi.joysticks[2].getRawAxis(0), Math.abs(driveDistancePIDOutput.getValue())), convert(Robot.oi.joysticks[0].getRawAxis(1), Robot.oi.joysticks[2].getRawAxis(0), 0), convert(Robot.oi.joysticks[0].getRawAxis(4), Robot.oi.joysticks[2].getRawAxis(1), 0), degrees);
				} else {
					robotDrive.mecanumDrive_Cartesian(convert(Robot.oi.joysticks[0].getRawAxis(0), Robot.oi.joysticks[2].getRawAxis(0), 0), convert(Robot.oi.joysticks[0].getRawAxis(1), Robot.oi.joysticks[2].getRawAxis(0), 0), convert(Robot.oi.joysticks[0].getRawAxis(4), Robot.oi.joysticks[2].getRawAxis(1), 0), degrees);
				}
			}
		} else {
			if (Robot.oi.joysticks[0].getRawButton(5)) {
				if (Math.abs(Robot.oi.joysticks[0].getRawAxis(1)) > 0.1) {
					robotDrive.mecanumDrive_Cartesian(convert(Robot.oi.joysticks[0].getRawAxis(0), Robot.oi.joysticks[2].getRawAxis(0), 0), convert(driveDistancePIDOutput.getValue(), Robot.oi.joysticks[2].getRawAxis(0), 0), convert(Robot.oi.joysticks[0].getRawAxis(4), Robot.oi.joysticks[2].getRawAxis(1), 0), degrees);
				} else {
					robotDrive.mecanumDrive_Cartesian(convert(Robot.oi.joysticks[0].getRawAxis(0), Robot.oi.joysticks[2].getRawAxis(0), 0), convert(Robot.oi.joysticks[0].getRawAxis(1), Robot.oi.joysticks[2].getRawAxis(0), 0), convert(Robot.oi.joysticks[0].getRawAxis(4), Robot.oi.joysticks[2].getRawAxis(1), 0), RobotMap.imu.getYaw());
				}
			} else {
				robotDrive.mecanumDrive_Cartesian(convert(Robot.oi.joysticks[0].getRawAxis(0), Robot.oi.joysticks[2].getRawAxis(0), 0), convert(Robot.oi.joysticks[0].getRawAxis(1), Robot.oi.joysticks[2].getRawAxis(0), 0), convert(Robot.oi.joysticks[0].getRawAxis(4), Robot.oi.joysticks[2].getRawAxis(1), 0), RobotMap.imu.getYaw());
			}
		}
	}
	
	public void setAccumulator (double degrees) {
		rotateAccumulator = degrees;
	}
}