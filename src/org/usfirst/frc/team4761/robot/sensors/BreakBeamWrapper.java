package org.usfirst.frc.team4761.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

/**
* Represents a distance sensor which is acting as a break-beam sensor.
*/

public class BreakBeamWrapper extends DistanceSensor {
	private double threshold = 50;	// half a meter default threshold

	public BreakBeamWrapper(AnalogInput sensor) {
		super(sensor);
	}
	public void setThreshold(double q) {
		threshold = q;
	}
	public boolean get() {
		return sensor.getVoltage() < threshold;
	}
}
