package org.usfirst.frc.team4761.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4761.robot.RobotMap;

/**
 * Subsystem that can move up an down on guide rails. Used for moving RCs up
 * and down, and putting them on top of piles.
 */
public class Elevator extends Subsystem {
	private static VictorSP speedController1 = RobotMap.elevatorMotor1;
	private static VictorSP speedController2 = RobotMap.elevatorMotor2;
	
	public void initDefaultCommand() {
	}
	
	public void raise () {
		speedController1.set(-0.6);
		speedController2.set(-0.6);
	}
	
	public void lower () {
		speedController1.set(0.2);
		speedController2.set(0.2);
	}
	
	public void stop () {
		speedController1.set(0);
		speedController2.set(0);
	}
}

