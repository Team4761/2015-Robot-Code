package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Motor that spins {@link org.usfirst.frc.team4761.robot.subsystems.RcGrabber
 * the RC Grabber}.
 */
public class RcGrabberBase extends Subsystem {
	public DigitalInput in = RobotMap.spinnerDI1;
	public DigitalInput out = RobotMap.spinnerDI2;
	VictorSP spinner = RobotMap.spinner;
	
	@Override
	protected void initDefaultCommand() {
	}
	
	public RcGrabberBase () {
	}
	
	public Boolean outTriggered () {
		return !out.get();
	}
	
	public Boolean inTriggered () {
		return !in.get();
	}
	
	public void goIn () {
		spinner.set(-0.6);
	}
	
	public void goOut () {
		spinner.set(0.6);
	}
	
	public void stop () {
		spinner.set(0);
	}
}
