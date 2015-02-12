package org.usfirst.frc.team4761.robot.subsystems;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4761.robot.RobotMap;

/**
 *
 */
public class UpperConveyerBelt extends Subsystem {
	//FIXME: Update this entire class for when the actual hardware comes out.
	private static double speed = 0.3;
	private static TalonSRX speedController = RobotMap.outerConveyorBeltMotor;
	
	public void initDefaultCommand() {
	}
	
	public static void go() {
		if (speed > 0) { //Conveyor belt can only go one way
			speedController.set(speed);
		}
	}
}
