package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Conveyor belt for moving RCs through the robot. Uses a Talon SRX speed
 * controller.
 */
public class MainConveyorBelt extends Subsystem {
	private static Talon speedController = RobotMap.mainConveyorBeltMotor;
	
	public void initDefaultCommand() {
	}
	
	public void forward () {
		speedController.set(1);
	}
	
	public void backward () {
		speedController.set(1);
	}
	
	public void go (double speed) {
		speedController.set(speed);
	}

	public void stop () {
		speedController.set(0);
	}
}
