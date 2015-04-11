package org.usfirst.frc.team4761.robot;

import java.io.File;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.simonandrews.robolog.LoggingMode;
import org.usfirst.frc.team4761.robot.sensors.DistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import com.kauailabs.navx_mxp.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Servo;
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
	
	// 1 = New Robot and any other number = Old Robot
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
	
	// New-New Gyro stuff
	public static SerialPort serial_port;

	public static AHRS imu;
	
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
	public static DigitalInput stackTop;
	
	/**
	 * Distance sensor on the front of the outer conveyor belt. Used for
	 * detecting when the elevator is at the top of a tote stack. Previously elevatorToteDistanceSensor
	 */
	public static ShortDistanceSensor outerConveyorBarrelDistanceSensor;
	
	public static Logger log;
	public static Level minLogLevel;
	
	public static DoubleSolenoid rcPneumatic;
	
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
	
	public static DigitalInput breakBeamElevatorEnd;
	public static DigitalInput breakBeamElevatorBegin;
	public static DigitalInput breakBeamClear;
	
	public static Talon mainConveyorBeltMotor;
	public static VictorSP elevatorConveyorBeltMotor;
	public static VictorSP elevatorMotor1;
	public static VictorSP elevatorMotor2;
	
	/**
	 * Arduino used for controlling the LEDs on the robot. Connected through an
	 * I2C interface.
	 */
	public static I2C arduino;
	
	/**
	 * Distance sensor used for testing.
	 */
	public static DistanceSensor testDistanceSensor1;
	
	/**
	 * Distance sensor used for testing.
	 */
	public static DistanceSensor testDistanceSensor2;

	/**
	 * Absolute path to the robots log file. Use {@link #logFile} in your code
	 * instead of making your own Files.
	 */
	public static String logFilePath = "/home/lvuser/log.txt";
	
	/**
	 * File object that uses the path value provided by {@link #logFilePath}.
	 */
	public static File logFile = new File(logFilePath);
	
	/**
	 * Absolute path to the robots settings file. Use {@link #settingsFile} in
	 * your code instead of making your own Files.
	 */
	public static String settingsFilePath = "/home/lvuser/settings.ini";
	
	/**
	 * File object that uses the path value provided by {@link
	 * #settingsFilePath}.
	 */
	public static File settingsFile = new File(settingsFilePath);
	
	//public static SupaDistanceSensor wallDistanceSensor;
	public static ShortDistanceSensor wallDistanceSensor;
	
	/**
	 * Stuff for the RcPickerUpper
	 */
	public static Servo servo;
	
	/**
	 * RC Alignment Tool
	 */
	public static DoubleSolenoid crusher;
	
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
		
		arduino = new I2C(I2C.Port.kOnboard, 168);
		
		// Robot specific electronics
		if (robot == 1) {
			leftFrontMotor = new VictorSP(3);
			leftRearMotor = new VictorSP(1);
			rightFrontMotor = new VictorSP(2);
			rightRearMotor = new VictorSP(0);
			
			robotDrive = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
			
			stackTop = new DigitalInput(18); // 8 on MXP
			
			log = new Logger("4761", LoggingMode.LOG, logFilePath); // Create an instance of our logging program
			minLogLevel = Level.DEV;
			
			rcPneumatic = new DoubleSolenoid(0, 0, 1);
			
			spinner = new VictorSP(4);
			
			spinnerDI1 = new DigitalInput(8);
			spinnerDI2 = new DigitalInput(9);
			
			elevatorBottom = new DigitalInput(21); // 11 on MXP
			elevatorAcceptTote1 = new DigitalInput(19); // 9 on MXP
			elevatorAcceptTote2 = new DigitalInput(23); // 13 MXP
			
			//breakBeamElevatorEnd = new DigitalInput(18); // Random Number (This is not on the robot yet)
			breakBeamElevatorBegin = new DigitalInput(20); // 10 on MXP
			breakBeamClear = new DigitalInput(22); // 12 on MXP
			
			mainConveyorBeltMotor = new Talon(6);
			elevatorConveyorBeltMotor = new VictorSP(7);
			elevatorMotor1 = new VictorSP(8);
			elevatorMotor2 = new VictorSP(9);
			
			//wallDistanceSensor = new ShortDistanceSensor(new AnalogInput(1));
			
			servo = new Servo(5);
			
			testDistanceSensor1 = new ShortDistanceSensor(new AnalogInput(2));
		} else {
			leftFrontMotor = new Victor(1);
			leftRearMotor = new Victor(2);
			rightFrontMotor = new Victor(3);
			rightRearMotor = new Victor(4);
			robotDrive = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
			
			log = new Logger("4761", LoggingMode.LOG, logFilePath);
			minLogLevel = Level.DEV;
			
			testDistanceSensor1 = new MediumDistanceSensor(new AnalogInput(2));
			testDistanceSensor2 = new MediumDistanceSensor(new AnalogInput(3));
						
			try {
				serial_port = new SerialPort(57600, SerialPort.Port.kMXP);
				
				byte update_rate_hz = 50;
				imu = new AHRS(serial_port, update_rate_hz);
		    } catch(Exception ex) {}
		}
	}
}
