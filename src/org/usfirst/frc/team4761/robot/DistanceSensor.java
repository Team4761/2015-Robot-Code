package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class DistanceSensor {
	AnalogInput sensor = RobotMap.distanceSensor;
	
	private double toCentiVolts (double voltage) {
		return voltage * 100;
	}
	
	public double getDistance () {
		return ((toCentiVolts(sensor.getVoltage())) / 4.885) * 5;
	}
}
