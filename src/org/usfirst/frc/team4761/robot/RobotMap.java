package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static RobotDrive robotDrive = new RobotDrive(1, 2, 3, 4);
	
	public static final Gyro gyro = new Gyro(0);
}
