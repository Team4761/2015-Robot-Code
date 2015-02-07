package org.usfirst.frc.team4761.robot;

import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

import edu.wpi.first.wpilibj.PIDSource;

public class GyroPIDSource implements PIDSource {
	private double deltaTime = 0;
	
	private GyroSensor gyro;
	
	public GyroPIDSource (GyroSensor gyro) {
		this.gyro = gyro;
	}

	public void setDeltaTime (double deltaTime) {
		this.deltaTime = deltaTime;
	}
	
	@Override
	public double pidGet() {
		return gyro.getDegrees(deltaTime);
	}
}
