package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class DistanceSensor {
	AnalogInput sensor = RobotMap.distanceSensor;
	
	private double toCentiVolts (double voltage) {
		return voltage * 100;
	}
	
	// Old ultrasonic sensor
	public double getDistance () {
		return ((toCentiVolts(sensor.getVoltage())) / 4.885) * 5;
	}
	
	// New medium range sensor
	public double getLongDistance () {
		double voltage = sensor.getVoltage();
		return 306.439 + voltage * (-512.611 + voltage * (382.268 + voltage * (-129.893 + voltage * 16.2537)));
	}
	
	// New short range sensor (NOT IMPLEMENTED!!!)
	public double getShortDistance () {
		double voltage = sensor.getVoltage();
		return 306.439 + voltage * (-512.611 + voltage * (382.268 + voltage * (-129.893 + voltage * 16.2537)));
	}
	
	public double getVoltage () {
		return sensor.getVoltage();
	}
}
