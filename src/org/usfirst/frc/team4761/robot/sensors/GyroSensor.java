package org.usfirst.frc.team4761.robot.sensors;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.I2C;

/*
 * IMPORTANT!!!
 * You will probably not understand this code and I am not going to make any attempt to put understandable comments on it.
 * Ask Jake Kinsella if you really need an explanation of this code
*/

public class GyroSensor {
	private static double degrees = 0; // The accumulated degrees from the get rotations per second function
	
	private I2C gyro = RobotMap.gyro;
	
	public GyroSensor () {
		gyro.write(0x6B, 0x03); // Power
		gyro.write(0x1A, 0x20); // Basic Config
		gyro.write(0x1B, 0x00); // Gyro Config
	}
	
	private int uByteToInt (byte number) {
		int iNumber = number & 0b01111111;

		if (number < 0) {
			iNumber += 128;
		}
		
		return iNumber;
	}
	
	private int toTwosComp (byte number) {
	    return uByteToInt((byte) ~number) + 0b00000001;
	}
	
	private int fromTwosComp (byte number) {
		return uByteToInt((byte) ~(number - 0b00000001));
	}
	
	public double getDegrees (double deltaTime) {
		byte[] angle = new byte[2];
		gyro.read(0x47, 2, angle);
		int highOrder = (int) angle[0];
		int lowOrder = uByteToInt(angle[1]);
		
		int rotation = fromTwosComp((byte) ((highOrder << 8) + lowOrder));
		
		degrees += (rotation / 131) * deltaTime;
		
		return degrees;
	}
	
	public double getTemp () {
		byte[] bTemp = new byte[2];
		gyro.read(0x41, 2, bTemp);
		int highOrder = (int) bTemp[0];
		int lowOrder = (int) bTemp[1];
		
		return (((highOrder << 8) + uByteToInt((byte) lowOrder)) / 340 + 36.5) * 9 / 5 + 32;
	}
}
