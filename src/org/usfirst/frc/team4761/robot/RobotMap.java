package org.usfirst.frc.team4761.robot;

import org.simonandrews.robolog.Logger;
import org.simonandrews.robolog.LoggingMode;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.I2C;
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
	
	// Old Gyro
	//public static final Gyro gyro = new Gyro(0);
	
	// New Gyro
	public static final I2C gyro = new I2C(I2C.Port.kOnboard, 0x68);
	
	public static final AnalogInput mediumDistanceSensor1 = new AnalogInput(0);

	public static final AnalogInput shortDistanceSensor1 = new AnalogInput(1);
	
	public static Logger log = new Logger("4761", LoggingMode.LOG, "/home/lvuser/log.txt");
	
	public static DoubleSolenoid rcpneumatic = new DoubleSolenoid(0, 0, 1); 
	
	public static DoubleSolenoid plowpneumatic = new DoubleSolenoid(0, 2, 3);
}
