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
	
	public static SpeedController leftFrontMotor;
	public static SpeedController leftRearMotor;
	public static SpeedController rightFrontMotor;
	public static SpeedController rightRearMotor;
	
	public static RobotDrive robotDrive;
	
	public static GyroSensor gyro;

	public static MediumDistanceSensor barrelDistanceSensor;
	public static MediumDistanceSensor elevatorDistanceSensor;
	public static MediumDistanceSensor outerConveyorToteDistanceSensor;

	public static ShortDistanceSensor outerConveyorBarrelDistanceSensor;
	
	public static Logger log;
	public static Level minLogLevel;
	
	public static DoubleSolenoid rcPneumatic;
	public static DoubleSolenoid plowPneumatic;
	
	public static VictorSP spinner;
	
	public static DigitalInput spinnerDI1;
	public static DigitalInput spinnerDI2;
	public static DigitalInput someDI;
	
	public static DigitalInput elevatorDI;
	
	public static Talon mainConveyorBeltMotor;
	public static VictorSP elevatorConveyorBeltMotor;
	public static VictorSP elevatorMotor1;
	public static VictorSP elevatorMotor2;
	
	public static DigitalInput elevatorMagnetDetectorDown;
	public static DigitalInput elevatorMagnetDetectorUp;
	
	public static AnalogInput flexSensor;
	
	public static I2C arduino;
	
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
		
			/**
			 * A magnet sensor that detects when it is in proximity to a magnet. It is used
			 * to obtain the position of the elevator. In this case the down position.
			 */
			
			elevatorMagnetDetectorDown = new DigitalInput(3);
			
			/**
			 * A magnet sensor that detects when it is in proximity to a magnet. It is used
			 * to obtain the position of the elevator. In this case the up position.
			 */
			
			elevatorMagnetDetectorUp = new DigitalInput(4);
			
			/**
			 * Distance sensor on the front of the outer conveyor belt. Used for
			 * detecting when the elevator is at the top of a tote stack. Previously elevatorToteDistanceSensor
			 */
			
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
			 * Digital input for the limit switch on the bottom of the elevator
			 */
			elevatorDI = new DigitalInput(2);
			
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
		}
	}
}
