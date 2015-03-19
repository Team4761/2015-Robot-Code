package org.usfirst.frc.team4761.robot;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.simonandrews.robolog.LoggingMode;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int robot = 1;
	/**
	 * Speed controller that controls the left front motor on the drive train.
	 */
	public static SpeedController leftFrontMotor;
	/**
	 * Speed controller that controls the left rear motor on the drive train.
	 */
	public static SpeedController leftRearMotor;
	/**
	 * Speed controller that controls the right front motor on the drive train.
	 */
	public static SpeedController rightFrontMotor;
	/**
	 * Speed controller that controls the right rear motor on the drive train.
	 */
	public static SpeedController rightRearMotor;
	
	/**
	 * Instance of RobotDrive for our drive train.
	 */
	public static RobotDrive robotDrive;
	
	public static GyroSensor gyro;

	/**
	 * A distance sensor that senses the barrels for auto-mode.
	 */
	public static MediumDistanceSensor barrelDistanceSensor;
	/**
	 * A distance sensor on the elevator.
	 */
	public static MediumDistanceSensor elevatorDistanceSensor;
	/**
	 * Distance sensor on the rear of the outer conveyor belt. Used for
	 * detecting something.
	 */
	public static MediumDistanceSensor outerConveyorToteDistanceSensor;
	/**
	 * Distance sensor on the front of the outer conveyor belt. Used for
	 * detecting when the elevator is at the top of a tote stack. Previously elevatorToteDistanceSensor
	 */
	public static ShortDistanceSensor outerConveyorBarrelDistanceSensor;
	
	public static Logger log;
	public static Level minLogLevel;
	
	public static DoubleSolenoid rcPneumatic;
	public static DoubleSolenoid plowPneumatic;
	
	public static VictorSP spinner;
	
	/**
	 * Digital input for the limit switches of the rcGrabberBase.
	 */
	public static DigitalInput spinnerDI1;
	
	/**
	 * Digital input for the limit switches of the rcGrabberBase.
	 */
	public static DigitalInput spinnerDI2;
	
	/**
	 * Digital input for the limit switch on the bottom of the elevator
	 */
	public static DigitalInput elevatorBottom;
	
	public static DigitalInput elevatorAcceptTote1;
	public static DigitalInput elevatorAcceptTote2;
	
	public static DigitalInput breakBeamBegin;
	public static DigitalInput breakBeamClear;
	
	public static Talon mainConveyorBeltMotor;
	public static VictorSP elevatorConveyorBeltMotor;
	public static VictorSP elevatorMotor1;
	public static VictorSP elevatorMotor2;
	
	public static AnalogInput flexSensor;
	
	public static I2C arduino;
	
	public static MediumDistanceSensor testDistanceSensor1;
	public static MediumDistanceSensor testDistanceSensor2;
	
	public RobotMap () {
		if (Settings.read("Robot") == 0) {
			// 1 for new robot and 2 for old robot
			Settings.write("Robot", 1);
			robot = Settings.read("Robot");
		} else {
			robot = Settings.read("Robot");
		}
		// Universal objects
		gyro = new GyroSensor();
		//gyro.gyroSensor.setSensitivity(0.007);
		//gyro.gyroSensor.reset();		
		
		arduino = new I2C(I2C.Port.kOnboard, 168);
		
		// Robot specific electronics
		if (robot == 1) {
			leftFrontMotor = new VictorSP(3);
			leftRearMotor = new VictorSP(1);
			rightFrontMotor = new VictorSP(2);
			rightRearMotor = new VictorSP(0);
			
			robotDrive = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
			
			barrelDistanceSensor = new MediumDistanceSensor(new AnalogInput(0));
			elevatorDistanceSensor = new MediumDistanceSensor(new AnalogInput(1));
			outerConveyorToteDistanceSensor = new MediumDistanceSensor(new AnalogInput(2));
			outerConveyorBarrelDistanceSensor = new ShortDistanceSensor(new AnalogInput(3));
			
			log = new Logger("4761", LoggingMode.LOG, "/home/lvuser/log.txt"); // Create an instance of our logging program
			minLogLevel = Level.DEV;
			
			rcPneumatic = new DoubleSolenoid(0, 0, 1);
			plowPneumatic = new DoubleSolenoid(0, 6, 7);
			
			spinner = new VictorSP(4);
			
			spinnerDI1 = new DigitalInput(8);
			spinnerDI2 = new DigitalInput(9);
			
			elevatorBottom = new DigitalInput(2);
			elevatorAcceptTote1 = new DigitalInput(1); // Random port
			elevatorAcceptTote2 = new DigitalInput(0); // Random port
			
			breakBeamBegin = new DigitalInput(3); // Random port
			breakBeamClear = new DigitalInput(4); // Random port
			
			mainConveyorBeltMotor = new Talon(6);
			elevatorConveyorBeltMotor = new VictorSP(7);
			elevatorMotor1 = new VictorSP(8);
			elevatorMotor2 = new VictorSP(9);

			flexSensor = new AnalogInput(4);
		} else {
			leftFrontMotor = new Victor(1);
			leftRearMotor = new Victor(2);
			rightFrontMotor = new Victor(3);
			rightRearMotor = new Victor(4);
			robotDrive = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
			
			log = new Logger("4761", LoggingMode.LOG, "/home/lvuser/log.txt");
			minLogLevel = Level.DEV;
			
			testDistanceSensor1 = new MediumDistanceSensor(new AnalogInput(2));
			testDistanceSensor2 = new MediumDistanceSensor(new AnalogInput(3));
			
			breakBeamBegin = new DigitalInput(13);
		}
	}
}
