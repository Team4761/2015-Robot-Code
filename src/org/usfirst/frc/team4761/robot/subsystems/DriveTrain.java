package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.DrivePIDOutput;
import org.usfirst.frc.team4761.robot.GyroPIDSource;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Base of the robot with wheels attached to it.
 */
public class DriveTrain extends Subsystem {
	private static double rotateAccumulator = 0; // Where the robot wants to be based on all of the accumulated values of the joystick
	
	RobotDrive robotDrive = RobotMap.robotDrive;
	
	GyroSensor gyro = new GyroSensor();
	GyroPIDSource gyroSensor = new GyroPIDSource(gyro);
    
	DrivePIDOutput driveGyroPIDOutput = new DrivePIDOutput();
    
	PIDController gyroPidController = new PIDController(0.01, 0.00025, 0.065, gyroSensor, driveGyroPIDOutput); // (P, I, D, input, output)
	
	public DriveTrain () {		
		gyroPidController.enable();
		
		gyroPidController.setSetpoint(0);
	}
	
    public void initDefaultCommand () {}
    
    // x and y = -1.0 - 1.0 & rotate is to infinity
    public void drive (double x, double y, double rotate, double deltaTime) {
    	rotateAccumulator += rotate;
    	gyroPidController.setSetpoint(rotateAccumulator);
    	
    	robotDrive.mecanumDrive_Cartesian(x, y, driveGyroPIDOutput.getValue(), gyro.getDegrees(deltaTime));
    	gyroSensor.setDeltaTime(deltaTime);
    }
    
    public void stop () {
    	robotDrive.drive(0, 0);
    }
    
    // Get z-axis and scale it
    public double getZ  (Joystick joystick) {
    	return (-0.3 * joystick.getZ() + 0.5);
    }
    
    // Calculate new speed based on the scaled z-axis
    public double convert (double input, Joystick joystick) {
    	return (input * getZ(joystick));
    }
    
    public void driveWithJoysticks (Joystick joystick1, Joystick joystick2, double deltaTime) {
    	double degrees = gyro.getDegrees(deltaTime);
    	
		System.out.println("Angle: " + degrees + " Accumulator: " + rotateAccumulator + " DrivePIDOutput: " + convert(driveGyroPIDOutput.getValue(), joystick1)); 
		
    	if (joystick1.getRawButton(2)) { // Press to move the robot to 0 degrees
    		if (Math.abs(rotateAccumulator) > 0) {
    			rotateAccumulator -= rotateAccumulator % 360;
    		} else {
    			rotateAccumulator += rotateAccumulator % 360;
    		}
    	}
    	
    	if (!(joystick2.getRawButton(2))) { // Hold down button two when sliding against walls
    		double joystickChange = convert(joystick1.getX(), joystick1) * 3.5;
    		if (Math.abs(joystickChange) > 0.05) { // Filter out noise
    			rotateAccumulator += joystickChange;
    		}
    		
    		gyroPidController.setSetpoint(rotateAccumulator);
        	
    		robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), driveGyroPIDOutput.getValue(), degrees);
    	} else {
    		robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), 0, degrees);
    		
    		rotateAccumulator = gyro.getDegrees(deltaTime); // Reset the accumulator so the robot doesn't jerk when button two is released
    	}
    }
}