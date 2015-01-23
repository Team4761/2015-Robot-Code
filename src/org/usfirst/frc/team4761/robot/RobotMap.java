package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static Victor leftFrontMotor = new Victor(1);
	public static Victor leftRearMotor = new Victor(2);
	public static Victor rightFrontMotor = new Victor(3);
	public static Victor rightRearMotor = new Victor(4);
	
	public static RobotDrive robotDrive = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
	
	public static final Gyro gyro = new Gyro(0);
	
	public static final AnalogInput distanceSensor = new AnalogInput(2);
}
