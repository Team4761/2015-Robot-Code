package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is a arm on the robot that will grab recycling bins off the step. This is not on the robot yet.
 */
public class RcArm extends Subsystem {
	Servo servo = RobotMap.servo;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void goToAngle (double angle) {
    	servo.setAngle(angle);
    }
}

