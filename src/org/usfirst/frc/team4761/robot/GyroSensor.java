package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.I2C;

/*
 * IMPORTANT!!!
 * You will probably not understant this code and I am not going to make any attempt to put understandable comments on it.
 * Ask Jake Kinsella if you really need an explanation of this code
*/

public class GyroSensor {
	private static double degrees = 0; // The accumulated degrees from the get rotations per second function
	
	private I2C gyro = RobotMap.gyro;
	
	public GyroSensor () {
		gyro.write(0x6B, 0x03); // Power
		gyro.write(0x1A, 0x18); // Basic Config
		gyro.write(0x1B, 0x00); // Gyro Config
	}
	
	public double getDegrees (double deltaTime) {
		byte[] angle = new byte[1];
		gyro.read(0x47, 1, angle); // Only read from on register (I don't know why the other one doesn't work)
		
		double rotation = (angle[0] * deltaTime) * 2; // I don't know why * 2 makes this work
		
		degrees += rotation;
		
		return -degrees;
	}
}
