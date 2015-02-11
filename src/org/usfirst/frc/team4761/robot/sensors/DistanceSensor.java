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
	 * Get voltage output of the sensor
	 * @return
	 */
	public double getVoltage () {
		return sensor.getVoltage();
	}
	
	/**
	 * Get distance in centimeters
	 * @return Distance in centimeters
	 */
	public double getDistance() {
		return (Double) null;
	}
}
