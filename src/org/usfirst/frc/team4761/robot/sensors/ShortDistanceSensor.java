package org.usfirst.frc.team4761.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * GP2D120XJ00F distance sensor
 */
public class ShortDistanceSensor extends DistanceSensor {
	public ShortDistanceSensor(AnalogInput sensor) {
		super(sensor);
	}
	
	public double getDistance() {
		double voltage = sensor.getVoltage();
		double distance = 17.298 * Math.pow(voltage, 2) - 66.8913 * voltage + 58.504; //TODO: not use exponents
		
		if (distance < 0) { // Filter out values less than 0
			return 0;
		}
		
		return distance;
	}
	
	public double getVoltage () {
		return sensor.getVoltage();
	}
}
