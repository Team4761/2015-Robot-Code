package org.usfirst.frc.team4761.robot.sensors;

import org.usfirst.frc.team4761.robot.Robot;

public class GyroThread implements Runnable {
	private double deltaTime = 0;
	
	public void run() {
		while (true) {
			Robot.robotMap.gyro.updateDegrees(deltaTime);

			System.out.println(GyroSensor.getDegrees());
		}
	}
}
