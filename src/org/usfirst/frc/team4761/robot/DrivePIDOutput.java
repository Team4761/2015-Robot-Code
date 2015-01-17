package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.PIDOutput;

public class DrivePIDOutput implements PIDOutput {
	private static double value = 0;
	
	@Override
	public void pidWrite(double output) {
		this.value = output;
	}
	
	public double getValue () {
		return this.value;
	}
}