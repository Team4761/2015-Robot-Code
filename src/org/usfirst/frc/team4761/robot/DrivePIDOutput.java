package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.PIDOutput;

// Dummy class to hold the output of the PID loop
public class DrivePIDOutput implements PIDOutput {
	private double value = 0;
	
	@Override
	public void pidWrite(double output) {
		this.value = output;
	}
	
	public double getValue() {
		return this.value;
	}
}
