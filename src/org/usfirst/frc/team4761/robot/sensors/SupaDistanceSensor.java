package org.usfirst.frc.team4761.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * How long until somebody tells me that they are going to change the name...
 */
public class SupaDistanceSensor extends DistanceSensor {

	public SupaDistanceSensor (AnalogInput sensor) {
		super(sensor);
	}
	
	public double getDistance () {
		return (7.01 - (sensor.getVoltage() / 0.78));
	}
	
	public double getVoltage () {
		return sensor.getVoltage();
	}
}
