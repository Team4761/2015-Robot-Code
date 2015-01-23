package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.DrivePIDOutput;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private static double accumulator = 0; // Where the robot wants to be based on all of the accumulated values of the joystick
	
	RobotDrive robotDrive = RobotMap.robotDrive;
	Gyro gyro = RobotMap.gyro;

    PIDSource gyroSensor = gyro;
	DrivePIDOutput drivePIDOutput = new DrivePIDOutput();
    
	PIDController pidController = new PIDController(0.01, 0.00025, 0, gyroSensor, drivePIDOutput); // (P, I, D, input, output)

	public DriveTrain () {
		pidController.enable();
	}
	
    public void initDefaultCommand() {
    	
    }
    
    public void drive (double leftSpeed, double rightSpeed) {
    	robotDrive.drive(leftSpeed, rightSpeed);
    }
    
    public void slide (double speed) {
    	// The values are inverted for a reason
    	RobotMap.leftFrontMotor.set(speed);
    	RobotMap.leftRearMotor.set(-speed);
    	RobotMap.rightFrontMotor.set(-speed);
    	RobotMap.rightRearMotor.set(speed);
    }
    
    public void stop () {
    	robotDrive.drive(0, 0);
    }
    
    // Get z-axis and scale it
    public double getZ(Joystick joystick) {
    	return (-0.2 * joystick.getZ() + 0.5);
    }
    
    // Calculate new speed based on the scaled z-axis
    public double convert (double input, Joystick joystick) {
    	return (input * getZ(joystick));
    }
    
    public void driveWithJoysticks (Joystick joystick1, Joystick joystick2) {
		System.out.println("Angle: " + gyro.getAngle() + " Accumulator: " + accumulator + " DrivePIDOutput: " + convert(drivePIDOutput.getValue(), joystick1)); 
		
    	if (joystick1.getRawButton(2)) { // Press to move the robot to 0 degrees
    		if (Math.abs(accumulator) > 0) {
    			accumulator -= accumulator % 360;
    		} else {
    			accumulator += accumulator % 360;
    		}
    	}
    	
    	if (!(joystick2.getRawButton(2))) { // Hold down button two when sliding against walls
    		double joystickChange = convert(joystick1.getX(), joystick1) * 3.5;
    		if (Math.abs(joystickChange) > 0.05) { // Filter out noise
    			accumulator += joystickChange;
    		}
    		
    		pidController.setSetpoint(accumulator);
        	
    		robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), drivePIDOutput.getValue(), gyro.getAngle());
    	} else {
    		robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), 0, gyro.getAngle());
    		
    		accumulator = gyro.getAngle(); // Reset the accumulator so the robot doesn't jerk when button two is released
    	}
    }
}