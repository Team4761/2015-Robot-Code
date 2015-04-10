package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RcPickerUpper extends Subsystem {
	private Servo servo = RobotMap.servo;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set (int angle) {
    	servo.set(angle);
    }
    
    public void open () {
    	servo.set(250); // Check this value
    }
    
    public void close () {
    	servo.set(0);
    }
}

