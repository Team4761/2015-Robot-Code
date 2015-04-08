package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is a arm on the robot that will grab recycling bins off the step. This is not on the robot yet.
 */
public class RcArm extends Subsystem {
	private Servo servo = RobotMap.servo;
	private VictorSP winch = RobotMap.winch;
    private DoubleSolenoid pusher = RobotMap.pusher;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void winchIn () {
    	winch.set(1);
    }
    
    public void winchOut () {
    	winch.set(-1);
    }
    
    public void winchStop () {
    	winch.set(0);
    }
    
    public void servoToAngle (double angle) {
    	servo.setAngle(angle);
    }
    
    public void pusherIn () {
    	pusher.set(DoubleSolenoid.Value.kForward);
    }
    
    public void pusherOut () {
    	pusher.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void pusherStop () {
    	pusher.set(DoubleSolenoid.Value.kOff);
    }
}

