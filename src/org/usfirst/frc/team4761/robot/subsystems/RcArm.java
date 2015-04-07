package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is a arm on the robot that will grab recycling bins off the step. This is not on the robot yet.
 */
public class RcArm extends Subsystem {
	private Servo servo = RobotMap.servo;
	private VictorSP winch = RobotMap.winch;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void in () {
    	winch.set(1);
    }
    
    public void out () {
    	winch.set(-1);
    }
    
    public void servoToAngle (double angle) {
    	servo.setAngle(angle);
    }
}

