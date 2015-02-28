package org.usfirst.frc.team4761.robot.sensors;

import org.usfirst.frc.team4761.robot.Robot;

public class GyroThread implements Runnable {
	private double deltaTime = 0;
	
	public void run() {
		while (true) {
			if (Robot.robotMap.gyro.updateDegrees(deltaTime)) {
				deltaTime = 0.05;
			} else {
				deltaTime += 0.05;
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
