package org.usfirst.frc.team4761.robot;

import org.simonandews.robolog.Logger;
import org.simonandews.robolog.LoggingMode;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Old robot
	public static Victor leftFrontMotor = new Victor(1);
	public static Victor leftRearMotor = new Victor(2);
	public static Victor rightFrontMotor = new Victor(3);
	public static Victor rightRearMotor = new Victor(4);
	
	// New robot
	/*public static VictorSP leftFrontMotor = new VictorSP(3);
	public static VictorSP leftRearMotor = new VictorSP(0);
	public static VictorSP rightFrontMotor = new VictorSP(2);
	public static VictorSP rightRearMotor = new VictorSP(1);*/
	
	public static RobotDrive robotDrive = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
	
	public static final Gyro gyro = new Gyro(0);
	
	public static final AnalogInput distanceSensor = new AnalogInput(2);
	
	public static Logger log = new Logger("4761", LoggingMode.LOG, "/home/lvuser/log.txt");
}
