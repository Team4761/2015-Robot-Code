package org.usfirst.frc.team4761.robot.sensors;

public class GyroThread implements Runnable {
	private double deltaTime = 0;
	
	public static GyroSensor sensor = new GyroSensor();
	
	public void run () {
		while (true) {
			if (sensor.updateDegrees(deltaTime)) {
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
