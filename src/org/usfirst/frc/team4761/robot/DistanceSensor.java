package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class DistanceSensor {
	AnalogInput sensor = RobotMap.distanceSensor;
	
	// New medium range sensor
	public double getLongDistance () {
		double voltage = sensor.getVoltage();
		return 306.439 + voltage * (-512.611 + voltage * (382.268 + voltage * (-129.893 + voltage * 16.2537)));
	}
	
	// New short range sensor
	public double getShortDistance () {
		double voltage = sensor.getVoltage();
		double distance = 17.298 * Math.pow(voltage, 2) - 66.8913 * voltage + 58.504;
		
		if (distance < 0) { // Filter out values less than 0
			return 0;
		}
		
		return distance;
	}
	
	public double getVoltage () {
		return sensor.getVoltage();
	}
}
