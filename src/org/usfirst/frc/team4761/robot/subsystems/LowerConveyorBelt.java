package org.usfirst.frc.team4761.robot.subsystems;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4761.robot.RobotMap;

/**
 * Conveyor belt for moving RCs through the robot. Uses a Talon SRX speed
 * controller.
 */
public class LowerConveyorBelt extends Subsystem {
	private static TalonSRX speedController = RobotMap.mainConveyorBeltMotor;
	
	public void initDefaultCommand() {
	}
	
	public void go(double speed) {
		if (speed > 0) { //conveyor belt can only go one way
			speedController.set(speed);
		}
	}
}
