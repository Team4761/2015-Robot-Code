package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.I2C;

public class GyroSensor {
	private static double degrees = 0;
	
	private I2C gyro = RobotMap.gyro;
	
	public GyroSensor () {
		gyro.write(0x6B, 0x03); // Power
		gyro.write(0x1A, 0x18); // Basic Config
		gyro.write(0x1B, 0x00); // Gyro Config
	}
	
	public double getDegrees (double deltaTime) {
		byte[] angle = new byte[1];
		gyro.read(0x47, 1, angle);
		
		double rotation = (angle[0] * deltaTime) * 2;
		
		degrees += rotation;
		
		return -degrees;
	}
}
