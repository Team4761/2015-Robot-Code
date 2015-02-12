package org.usfirst.frc.team4761.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4761.robot.RobotMap;

/**
 * Wedge for moving totes out of the way.
 */
public class Plower extends Subsystem {
	
	private DoubleSolenoid solenoid = RobotMap.plowPneumatic;
	
	public void initDefaultCommand() {
	}
	
	public void set(DoubleSolenoid.Value value) {
		solenoid.set(value);
	}
}

