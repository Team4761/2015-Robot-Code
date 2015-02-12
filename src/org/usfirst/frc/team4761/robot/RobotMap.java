package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.*;

import org.simonandrews.robolog.Logger;
import org.simonandrews.robolog.LoggingMode;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	/* 
	 * Old robot
	 * public static Victor leftFrontMotor = new Victor(1);
	 * public static Victor leftRearMotor = new Victor(2);
	 * public static Victor rightFrontMotor = new Victor(3);
	 * public static Victor rightRearMotor = new Victor(4);
	 */
	
	public static VictorSP leftFrontMotor = new VictorSP(3);
	public static VictorSP leftRearMotor = new VictorSP(0);
	public static VictorSP rightFrontMotor = new VictorSP(2);
	public static VictorSP rightRearMotor = new VictorSP(1);
	
	
	public static RobotDrive robotDrive = new RobotDrive(leftFrontMotor,
			leftRearMotor, rightFrontMotor, rightRearMotor);
	
	// Old Gyro
	//public static final Gyro gyro = new Gyro(0);
	
	// New Gyro
	public static final I2C gyro = new I2C(I2C.Port.kOnboard, 0x68);
	
	/**
	 * A distance sensor that is only used in the {@link org.usfirst.frc.
	 * team4761.robot.commands.LogToFile Log To File Command}. Jake says its 
	 * not being used right now.
	 */
	//public static final MediumDistanceSensor mediumDistanceSensor1 = new MediumDistanceSensor(new AnalogInput(0));
	
	/**
	 * A distance sensor on the elevator.
	 */
	public static final ShortDistanceSensor elevatorDistanceSensor = new ShortDistanceSensor(new AnalogInput(1));
	
	/**
	 * The distance sensor to check for barrels.
	 */
	public static final ShortDistanceSensor barrelSensor = new ShortDistanceSensor(new AnalogInput(2)); // Please update when ports are finalized
	
	public static Logger log = new Logger("4761", LoggingMode.LOG, "/home/lvuser/log.txt"); // Create an instance of our logging program
	
	public static DoubleSolenoid rcPneumatic = new DoubleSolenoid(0, 0, 1);
	public static DoubleSolenoid plowPneumatic = new DoubleSolenoid(0, 2, 3);
	
	// New Robot
	public static AnalogInput rcPot = new AnalogInput(5); //TODO: Remove after merge
	public static VictorSP spinner = new VictorSP(4);
	
	/**
	 * Digital inputs for the limit switches of the rcGrabberBase.</br>
	 */
	public static DigitalInput spinnerDI1 = new DigitalInput(0);
	public static DigitalInput spinnerDI2 = new DigitalInput(1);
	
	public static TalonSRX mainConveyorBeltMotor = new TalonSRX(6);
	public static TalonSRX elevatorConveyorBeltMotor = new TalonSRX(7);
	public static VictorSP elevatorMotor = new VictorSP(5);
	
}
