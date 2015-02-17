package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.*;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.simonandrews.robolog.LoggingMode;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static VictorSP leftFrontMotor = new VictorSP(3);
	public static VictorSP leftRearMotor = new VictorSP(1);
	public static VictorSP rightFrontMotor = new VictorSP(2);
	public static VictorSP rightRearMotor = new VictorSP(0);
	
	
	public static RobotDrive robotDrive = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
	
	// New Gyro
	public static final GyroSensor gyro = new GyroSensor();
	
	/**
	 * A distance sensor that senses the barrels for auto-mode.
	 */
	public static final MediumDistanceSensor barrelDistanceSensor = new MediumDistanceSensor(new AnalogInput(0));
	
	/**
	 * A distance sensor on the elevator.
	 */
	public static final MediumDistanceSensor elevatorDistanceSensor = new MediumDistanceSensor(new AnalogInput(1));
	
	/**
	 * Distance sensor on the rear of the outer conveyor belt. Used for
	 * detecting something. TODO: Figure out what it's use is. Previously elevatorBarrelDistanceSensor
	 */
	public static final ShortDistanceSensor outerConveyorBarrelDistanceSensor = new ShortDistanceSensor(new AnalogInput(2));
	
	/**
	 * Distance sensor on the front of the outer conveyor belt. Used for
	 * detecting when the elevator is at the top of a tote stack. Previously elevatorToteDistanceSensor
	 */
	public static final MediumDistanceSensor outerConveyorToteDistanceSensor = new MediumDistanceSensor(new AnalogInput(3));

	public static Logger log = new Logger("4761", LoggingMode.LOG, "/home/lvuser/log.txt"); // Create an instance of our logging program
	public static Level minLogLevel = Level.DEV;
	
	public static DoubleSolenoid rcPneumatic = new DoubleSolenoid(0, 0, 1);
	public static DoubleSolenoid plowPneumatic = new DoubleSolenoid(0, 6, 7);
	
	// New Robot
	public static VictorSP spinner = new VictorSP(4);
	
	/**
	 * Digital inputs for the limit switches of the rcGrabberBase.</br>
	 */
	public static DigitalInput spinnerDI1 = new DigitalInput(8);
	public static DigitalInput spinnerDI2 = new DigitalInput(9);
	
	/**
	 * Digital inputs for the limit switch on the bottom of the elevator
	 */
	public static DigitalInput elevatorDI = new DigitalInput(2);
	
	public static Talon mainConveyorBeltMotor = new Talon(6);
	public static VictorSP elevatorConveyorBeltMotor = new VictorSP(7);
	public static VictorSP elevatorMotor1 = new VictorSP(8);
	public static VictorSP elevatorMotor2 = new VictorSP(9);
}
