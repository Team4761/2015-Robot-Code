package org.usfirst.frc.team4761.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

/**
 * Motor that spins {@link org.usfirst.frc.team4761.robot.subsystems.RcGrabber
 * the RC Grabber}.
 */
public class RcGrabberBase extends Subsystem {
	public DigitalInput in = Robot.robotMap.spinnerDI1;
	public DigitalInput out = Robot.robotMap.spinnerDI2;
	VictorSP spinner = Robot.robotMap.spinner;
	
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
	
	public void spinnerSet (Double speed) {
		spinner.set(speed);
	}
}
