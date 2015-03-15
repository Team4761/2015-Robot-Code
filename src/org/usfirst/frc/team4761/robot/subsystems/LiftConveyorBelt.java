package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Conveyor belt attached to the elevator that can move totes on it onto the
 * top of a stack.
 */
public class LiftConveyorBelt extends Subsystem {
	private static VictorSP speedController = RobotMap.elevatorConveyorBeltMotor;
	
	public void initDefaultCommand () {
	}
	
	public void go (double speed) {
		speedController.set(speed);
	}

	public void stop() {
		speedController.set(0);
	}
}
