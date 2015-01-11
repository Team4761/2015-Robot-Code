package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.Adjust;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	boolean selfAdjust = true;
	
	RobotDrive robotDrive = RobotMap.robotDrive;
	Adjust adjust = new Adjust();
	
    GyroSensor gyroSensor = new GyroSensor();
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
    	if (joystick2.getRawButton(2)) {
    		System.out.println("TEST");
    		selfAdjust = !selfAdjust;
    	}
    	
    	if (selfAdjust) {
    		//robotDrive.mecanumDrive_Polar(joystick2.getMagnitude(), -(joystick2.getDirectionDegrees()), joystick1.getX());
    		System.out.println("Angle: " + gyroSensor.getAngle() + " Accumulator: " + adjust.getValue() + " Self Adjust: " + selfAdjust);
    		adjust.add(convert(joystick1.getX() * 2, joystick1));
    		robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), adjust.difference(gyroSensor.getAngle()), gyroSensor.getAngle());
    	} else {
    		System.out.println("Angle: " + gyroSensor.getAngle() + " Accumulator: " + adjust.getValue() + " Self Adjust: " + selfAdjust);
    		robotDrive.mecanumDrive_Cartesian(convert(joystick2.getX(), joystick2), convert(joystick2.getY(), joystick2), 0, gyroSensor.getAngle());
    	}
    }
}