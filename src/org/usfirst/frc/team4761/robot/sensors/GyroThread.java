package org.usfirst.frc.team4761.robot.sensors;

public class GyroThread implements Runnable {
	private double deltaTime = 0;
	private long begin = 0, end = 0;
	
	public static GyroSensor sensor = new GyroSensor();
	
	public void run () {
		while (true) {
			begin = System.nanoTime();
			
			sensor.updateDegrees(deltaTime);
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			deltaTime = (begin - end) / 1000000000.0;
			end = System.nanoTime();
		}
	}
}
