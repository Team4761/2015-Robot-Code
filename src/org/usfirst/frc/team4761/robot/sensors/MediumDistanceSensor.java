package org.usfirst.frc.team4761.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * GP2Y0A02YK0F distance sensor
 */
public class MediumDistanceSensor extends DistanceSensor {
	public MediumDistanceSensor(AnalogInput sensor) {
		super(sensor);
	}
	
	/**
	 * Get distance in centimeters
	 *
	 * @return Distance in centimeters
	 */
	public double getDistance() {
		double voltage = sensor.getVoltage();
		return 306.439 + voltage * (-512.611 + voltage * (382.268 + voltage * (-129.893 + voltage * 16.2537)));
	}
	
}
