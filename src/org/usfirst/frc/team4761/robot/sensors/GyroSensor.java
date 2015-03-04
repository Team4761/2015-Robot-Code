package org.usfirst.frc.team4761.robot.sensors;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.I2C;

/**
 * Class for working with the I2C powered MPU-6050 gyro. Would probably also
 * work with an MPU-6000 if we get one in the future.
 * <a href="http://invensense.com/mems/gyro/mpu6050.html">Product Spec</a>.
 * 
 * IMPORTANT!!!
 * You will probably not understand this code and I am not going to make any attempt to put understandable comments on it.
 * Ask Jake Kinsella if you really need an explanation of this code
 */
public class GyroSensor {
	private static double degrees = 0; // The accumulated degrees from the get rotations per second function
	private double rotation = 0; // The degrees of the blue gyro
	
	private I2C gyro = new I2C(I2C.Port.kOnboard, 0x68);
	
	public Gyro gyroSensor = new Gyro(0); // Blue Gyro
	
	// Blue Gyro
	public double getAngle () {
		rotation = gyroSensor.getAngle();
		return rotation;
	}
	
	public void setOffset (double offset) {
		rotation += offset;
	}
	
	// I2C gyro
	public GyroSensor () {
		gyro.write(0x6B, 0x00); // Power Config
		gyro.write(0x1A, 0x26); // Basic Config
		gyro.write(0x1B, 0x00); // Gyro Config
		gyro.write(0x38, 0x11); // Interrupt Config
		gyro.write(0x23, 0x10); // FIFO Config
		gyro.write(0x6A, 0x04); // User Control (Turn off FIFO and reset it)
		gyro.write(0x6A, 0x40); // User Control (Turn FIFO back on);
	}
	
	private int uByteToInt (byte number) {
		int iNumber = number & 0b01111111;
		
		if (number < 0) {
			iNumber += 128;
		}
		
		return iNumber;
	}
	
	public static double getDegrees () {
		return degrees;
	}
	
	public void setDegrees (double rotation) {
		degrees = rotation;
	}
	
	public boolean updateDegrees (double deltaTime) {
		byte[] overflow = new byte[1];
		gyro.read(0x3A, 1, overflow);
		
		if ((overflow[0] & 0b00010000) != 0) {
			System.out.println("FIFO BUFFER HAS OVERFLOWED!!! THE GYRO WILL NOW BE INACCURATE UNTIL RESTART!!!");
		}
		
		byte[] fifoCount = new byte[2];
		gyro.read(0x72, 2, fifoCount);
		int highOrder = uByteToInt(fifoCount[0]);
		int lowOrder = uByteToInt(fifoCount[1]);
		
		int count = (highOrder << 8) + lowOrder;
		
		System.out.println("Count: " + count);
		
		if (count >= 2) { // FIFO registers are not empty
			for (int i = 0; i < count; i += 2) {
				byte[] highOrderByte = new byte[1];
				gyro.read(0x74, 1, highOrderByte);
				byte[] lowOrderByte = new byte[1];
				gyro.read(0x74, 1, lowOrderByte);
				
				highOrder = (int) highOrderByte[0];
				lowOrder = uByteToInt(lowOrderByte[0]);
				
				int rotation = ((highOrder << 8) + lowOrder) / 1000;
				
				degrees += -(rotation / 131.0);
			}
		}
		
		return false;
	}
	
	public boolean updateDegreesOld (double deltaTime) {
		byte[] dataReady = new byte[1];
		gyro.read(0x3A, 1, dataReady);
		
		if ((dataReady[0] & 0x00000001) > 0) {
			byte[] angle = new byte[2];
			gyro.read(0x47, 2, angle);
			int highOrder = (int) angle[0];
			int lowOrder = uByteToInt(angle[1]);
			
			int rotation = (highOrder << 8) + lowOrder;
			
			double newRotation = (rotation / 131.0) * deltaTime;
			if (Robot.robotMap.robot == 1) {
				if (newRotation > 0.055 || newRotation < -0.055) { // Filter out noise
					degrees += -newRotation;
				}
			} else {
				System.out.println("Test");
				if (newRotation > 0.2 || newRotation < -0.2) { // Filter out noise
					degrees += -newRotation;
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	public double getTemp () {
		byte[] bTemp = new byte[2];
		gyro.read(0x41, 2, bTemp);
		int highOrder = (int) bTemp[0];
		int lowOrder = (int) bTemp[1];
		
		return (((highOrder << 8) + uByteToInt((byte) lowOrder)) / 340 + 36.5) * 9 / 5 + 32;
	}
}
