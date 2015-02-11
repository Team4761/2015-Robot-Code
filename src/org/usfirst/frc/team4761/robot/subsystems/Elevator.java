package org.usfirst.frc.team4761.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4761.robot.RobotMap;

/**
 * Subsystem that can move up an down on guide rails. Used for moving RCs up
 * and down, and putting them on top of piles.
 */
public class Elevator extends Subsystem {
	//TODO: Check if this speed is appropriate when the hardware exists.
	private static double speed = 0.3;
	private static VictorSP speedController = RobotMap.elevatorMotor;
	
	public void initDefaultCommand() {
	}
	
	public static void raise() {
		speedController.set(speed);
	}
	
	public static void lower() {
		speedController.set(-speed);
	}
}

