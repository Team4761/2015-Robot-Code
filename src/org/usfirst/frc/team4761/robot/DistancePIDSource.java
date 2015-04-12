package org.usfirst.frc.team4761.robot;

import org.usfirst.frc.team4761.robot.sensors.DistanceSensor;

import edu.wpi.first.wpilibj.PIDSource;

public class DistancePIDSource implements PIDSource {
	private DistanceSensor sensor;
	
	public DistancePIDSource (DistanceSensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public double pidGet() {
		if (sensor.getDistance() < 6) {
			return sensor.getDistance();
		} else {
			return 50;
		}
	}
}