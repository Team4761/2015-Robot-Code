package org.usfirst.frc.team4761.robot;

import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

import edu.wpi.first.wpilibj.PIDSource;
/**
 * Wrapper class for PIDSource.
 */
public class GyroPIDSource implements PIDSource {

	public GyroPIDSource() {
	}
	
	@Override
	public double pidGet() {
		return GyroSensor.getDegrees();
	}
}
