package org.usfirst.frc.team4761.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Represents a distance sensor.
 * GP2Y0A02YK0F (long) datasheet: 
 * https://www.sparkfun.com/datasheets/Sensors/Infrared/gp2y0a02yk_e.pdf
 * GP2D120XJ00F (short) datasheet:
 * https://www.sparkfun.com/datasheets/Sensors/Infrared/GP2D120XJ00F_SS.pdf
 */
public class DistanceSensor {
	AnalogInput sensor;
	
	public DistanceSensor (AnalogInput sensor) {
		this.sensor = sensor;
	}
	
	/**
	 * New medium range sensor
	 * GP2Y0A02YK0F distance sensor
	 * @return Distance in centimeters
	 */
	public double getLongDistance () {
		double voltage = sensor.getVoltage();
		return 306.439 + voltage * (-512.611 + voltage * (382.268 + voltage * (-129.893 + voltage * 16.2537)));
	}
	
	/**
	 * New short range sensor
	 * GP2D120XJ00F distance sensor
	 * @return Distance in centimeters.
	 */
	public double getShortDistance () {
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
