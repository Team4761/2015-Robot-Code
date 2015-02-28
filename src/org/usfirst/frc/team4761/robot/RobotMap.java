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
	public String robot = "OLD";
	
	public SpeedController leftFrontMotor;
	public SpeedController leftRearMotor;
	public SpeedController rightFrontMotor;
	public SpeedController rightRearMotor;
	
	public RobotDrive robotDrive;
	
	public GyroSensor gyro;
	
	public MediumDistanceSensor barrelDistanceSensor;
	public MediumDistanceSensor elevatorDistanceSensor;
	public MediumDistanceSensor outerConveyorToteDistanceSensor;

	public ShortDistanceSensor outerConveyorBarrelDistanceSensor;
	
	public Logger log;
	public Level minLogLevel;
	
	public DoubleSolenoid rcPneumatic;
	public DoubleSolenoid plowPneumatic;
	
	public VictorSP spinner;
	
	public DigitalInput someDI;
	public DigitalInput spinnerDI1;
	public DigitalInput spinnerDI2;
	
	public DigitalInput elevatorDI;
	
	public Talon mainConveyorBeltMotor;
	public VictorSP elevatorConveyorBeltMotor;
	public VictorSP elevatorMotor1;
	public VictorSP elevatorMotor2;
	
	public RobotMap () {
		// Universal electronics
		gyro = new GyroSensor();
		
		// Robot specific electronics
		if (robot.equals("NEW")) {
			leftFrontMotor = new VictorSP(3);
			leftRearMotor = new VictorSP(1);
			rightFrontMotor = new VictorSP(2);
			rightRearMotor = new VictorSP(0);
			
			
			robotDrive = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
			
			// New Gyro
			gyro = new GyroSensor();
			
			/**
			 * A distance sensor that senses the barrels for auto-mode.
			 */
			barrelDistanceSensor = new MediumDistanceSensor(new AnalogInput(0));
			
			/**
			 * A distance sensor on the elevator.
			 */
			elevatorDistanceSensor = new MediumDistanceSensor(new AnalogInput(1));
			
			/**
			 * Distance sensor on the rear of the outer conveyor belt. Used for
			 * detecting something.
			 */
			outerConveyorToteDistanceSensor = new MediumDistanceSensor(new AnalogInput(2));
			
			/**
			 * Distance sensor on the front of the outer conveyor belt. Used for
			 * detecting when the elevator is at the top of a tote stack. Previously elevatorToteDistanceSensor
			 */
			outerConveyorBarrelDistanceSensor = new ShortDistanceSensor(new AnalogInput(3));
		
			log = new Logger("4761", LoggingMode.LOG, "/home/lvuser/log.txt"); // Create an instance of our logging program
			minLogLevel = Level.DEV;
			
			rcPneumatic = new DoubleSolenoid(0, 0, 1);
			plowPneumatic = new DoubleSolenoid(0, 6, 7);
			
			spinner = new VictorSP(4);
			
			/**
			 * Digital inputs for the limit switches of the rcGrabberBase.</br>
			 */
			spinnerDI1 = new DigitalInput(8);
			spinnerDI2 = new DigitalInput(9);
			
			/**
			 * Digital inputs for the limit switches for the side of the robot (NOT IMPLEMENTED!!!).</br>
			 */
			/*public static DigitalInput sideDI1 = new DigitalInput(0);
			public static DigitalInput sideDI2 = new DigitalInput(1);*/
			
			/**
			 * Digital input for the limit switch on the bottom of the elevator
			 */
			elevatorDI = new DigitalInput(2);
			
			mainConveyorBeltMotor = new Talon(6);
			elevatorConveyorBeltMotor = new VictorSP(7);
			elevatorMotor1 = new VictorSP(8);
			elevatorMotor2 = new VictorSP(9);
		} else {
			leftFrontMotor = new Victor(1);
			leftRearMotor = new Victor(2);
			rightFrontMotor = new Victor(3);
			rightRearMotor = new Victor(4);
			robotDrive = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
			
			log = new Logger("4761", LoggingMode.LOG, "/home/lvuser/log.txt");
			minLogLevel = Level.DEV;
		}
	}
}