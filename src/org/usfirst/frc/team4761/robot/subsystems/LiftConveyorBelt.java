package org.usfirst.frc.team4761.robot.subsystems;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4761.robot.RobotMap;

/**
 * Conveyor belt attached to the elevator that can move totes on it onto the
 * top of a stack.
 */
public class LiftConveyorBelt extends Subsystem {
	private static TalonSRX speedController = RobotMap.elevatorConveyorBeltMotor;
	
	public void initDefaultCommand() {
	}
	
	public void go(double speed) {
		if (speed > 0) { //Conveyor belt can only go one way
			speedController.set(speed);
		}
	}
}
