package org.usfirst.frc.team4761.robot.sensors;

import org.usfirst.frc.team4761.robot.RobotMap;

/**
 * A thread to run to keep the gyro updated.
 */

public class GyroThread implements Runnable {
	private double deltaTime = 0;
	
	public void run() {
		while (true) {
			if (RobotMap.gyro.updateDegreesOld(deltaTime)) {
				deltaTime = 0.05;
			} else {
				deltaTime += 0.05;
			}

			//System.out.println(GyroSensor.getDegrees());
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
