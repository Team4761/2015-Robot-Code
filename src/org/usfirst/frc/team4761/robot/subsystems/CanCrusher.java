package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CanCrusher extends Subsystem {
    private DoubleSolenoid crusher = RobotMap.crusher;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void extend () {
    	crusher.set(DoubleSolenoid.Value.kForward);
    }
    
    public void retract () {
    	crusher.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void off () {
    	crusher.set(DoubleSolenoid.Value.kOff);
    }
}