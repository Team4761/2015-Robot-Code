package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GyroSensor extends Subsystem {
	Gyro gyro = RobotMap.gyro;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getRate () {
    	return gyro.getRate();
    }
    
    public double getAngle() {
    	//return (-(gyro.getAngle()) % 360);
    	return gyro.getAngle();
    }
}

