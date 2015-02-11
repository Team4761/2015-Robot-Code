package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Arm with a hook on the end that can grab RCs
 */
public class RCGrabber extends Subsystem {
    
    public DoubleSolenoid solenoid = RobotMap.rcpneumatic;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set (DoubleSolenoid.Value value) {
    	solenoid.set(value);
    }
}