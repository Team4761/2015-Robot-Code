package org.usfirst.frc.team4761.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Represents a distance sensor. Extend this if you are making a class for a
 * new distance sensor
 */
public class DistanceSensor {
	AnalogInput sensor;
	
	/**
	 * If you try to make an instance of DistanceSensor anywhere, Eclipse will
	 * tell you to change the visibility of this constructor to public. DO NOT
	 * DO THIS. Use a subclass of this class instead.
	 *
	 * @param sensor The AnalogInput object that is configured to the port the
	 *               sensor is on
	 */
	protected DistanceSensor(AnalogInput sensor) {
		this.sensor = sensor;
	}
	
	/**
	 * Get voltage output of the sensor
	 *
	 * @return Voltage output of sensor
	 */
	public double getVoltage() {
		return sensor.getVoltage();
	}
	
	/**
	 * Get distance in centimeters
	 *
	 * @return Distance in centimeters the sensor is from the closest object it
	 * can detect
	 */
	public double getDistance() {
		return (Double) null;
	}
}
