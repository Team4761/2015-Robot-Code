package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.DrivePIDOutput;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private boolean reset = false;
	
	private static double accumulator = 0;
	
	RobotDrive robotDrive = RobotMap.robotDrive;	
	Gyro gyro = RobotMap.gyro;

    PIDSource gyroSensor = gyro;
	DrivePIDOutput drivePIDOutput = new DrivePIDOutput();
    
	PIDController pidController = new PIDController(0.01, 0.00025, 0.065, gyroSensor, drivePIDOutput);

	public DriveTrain () {
		pidController.enable();
	}
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive (double leftSpeed, double rightSpeed) {
    	robotDrive.drive(leftSpeed, rightSpeed);
    }
    
    public double getZ(Joystick joystick) {
    	return (-0.2 * joystick.getZ() + 0.5);
    }
    
    public double convert (double input, Joystick joystick) {
    	return (input * getZ(joystick));
    }
    
    public void driveWithJoysticks (Joystick joystick1, Joystick joystick2) {
		System.out.println("Angle: " + gyro.getAngle() + " Accumulator: " + accumulator + " DrivePIDOutput: " + convert(drivePIDOutput.getValue(), joystick1)); 
		
    	if (joystick1.getRawButton(2)) { // Press to move the robot to 0 degrees
    		reset = true;
    		if (Math.abs(accumulator) > 0) {
    			accumulator -= accumulator % 360;
    		} else {
    			accumulator += accumulator % 360;
    		}
    	}
    	
    	if (!(joystick2.getRawButton(2))) { // Hold down button two when sliding against walls
    		double tmp = convert(joystick1.getX(), joystick1) * 3.5;
    		if (Math.abs(tmp) > 0.05) { // Filter out noise
    			accumulator += tmp;
    		}
    		
    		pidController.setSetpoint(accumulator);
        	
    		robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), drivePIDOutput.getValue(), gyro.getAngle());
    	} else {
    		robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), 0, gyro.getAngle());
    		
    		accumulator = gyro.getAngle(); // Reset the accumulator so the robot doesn't jerk when button two is released
    	}
    }
}