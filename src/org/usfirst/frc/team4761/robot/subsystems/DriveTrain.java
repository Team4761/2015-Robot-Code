package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.DrivePIDOutput;
import org.usfirst.frc.team4761.robot.Robot;
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
	private static double accumulator = 0;
	
	RobotDrive robotDrive = RobotMap.robotDrive;	
	Gyro gyro = RobotMap.gyro;

    PIDSource gyroSource = gyro;
	DrivePIDOutput drivePIDOutput = new DrivePIDOutput();
    
	PIDController pidController = new PIDController(0.01, 0, 0, gyroSource, drivePIDOutput, 0.01);

	public DriveTrain () {
		pidController.setContinuous(true);
		
		pidController.enable();
		
		SmartDashboard.putData("PID", pidController);
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
    	if (!(joystick2.getRawButton(2))) { // Hold down button two when sliding against walls
    		System.out.println("Angle: " + gyro.getAngle() + " Accumulator: " + accumulator + " DrivePIDOutput: " + convert(drivePIDOutput.getValue(), joystick1) + " Self Adjust: True"); 		
    		
    		double tmp = convert(joystick1.getX() * 5, joystick1);
    		if (Math.abs(tmp) < 0.01) { // Filter out random noise
    			accumulator += tmp;
    		}
    		
        	pidController.setSetpoint(accumulator);
        	
    		robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), convert(drivePIDOutput.getValue(), joystick1), gyro.getAngle());
    	} else {
    		System.out.println("Angle: " + gyro.getAngle() + " Accumulator: " + accumulator + " DrivePIDOutput: " + convert(drivePIDOutput.getValue(), joystick1) + " Self Adjust: True"); 		
    		
    		robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), 0, gyro.getAngle());
    		
    		accumulator = gyro.getAngle(); // Reset the accumulator so the robot doesn't jerk when button two is released
    	}
    }
}