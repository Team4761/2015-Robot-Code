package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is a arm on the robot that will grab recycling bins off the step. This is not on the robot yet.
 */
public class RcArm extends Subsystem {
	private Servo servo = RobotMap.servo;
	private Talon winch = RobotMap.winch;
	private DoubleSolenoid pusher = RobotMap.pusher;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void winchIn () {
    	if (RobotMap.mousetrapFired.get()) {
    		retractPusher();
    	}
    	
    	winch.set(0.3);
    }
    
    public void winchOut () {
    	winch.set(-0.3);
    }
    
    public void winchStop () {
    	winch.set(0);
    }
    
    public void servoToAngle (double angle) {
    	servo.setAngle(angle);
    }
    
    public void extendPusher () {    	
    	if (!RobotMap.mousetrapFired.get()) {
    		pusher.set(DoubleSolenoid.Value.kForward);
    	}
    }
    
    public void retractPusher () {
    	pusher.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void pusherOff () {
    	pusher.set(DoubleSolenoid.Value.kOff);
    }
}

