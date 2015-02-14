package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.PIDSource;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

public class GyroPIDSource implements PIDSource {
	private double deltaTime = 0;
	
	public GyroPIDSource() {
	}
	
	public void setDeltaTime(double deltaTime) {
		this.deltaTime = deltaTime;
	}
	
	@Override
	public double pidGet() {
		return GyroSensor.getDegrees();
	}
}
