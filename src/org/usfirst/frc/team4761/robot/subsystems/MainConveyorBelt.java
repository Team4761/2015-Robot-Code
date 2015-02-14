package org.usfirst.frc.team4761.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4761.robot.RobotMap;

/**
 * Conveyor belt for moving RCs through the robot. Uses a Talon SRX speed
 * controller.
 */
public class MainConveyorBelt extends Subsystem {
	private static Talon speedController = RobotMap.mainConveyorBeltMotor;
	
	public void initDefaultCommand() {
	}
	
	public void go(double speed) {
		speedController.set(speed);
	}
}
