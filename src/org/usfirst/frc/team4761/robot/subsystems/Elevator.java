package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		speedController1.set(-0.85);
		speedController2.set(-0.85);
	}
	
	public void lower () {
		speedController1.set(0.3);
		speedController2.set(0.3);
	}
	
	public void set (double speed) {
		speedController1.set(speed);
		speedController2.set(speed);
	}
	
	public void stop () {
		speedController1.set(0);
		speedController2.set(0);
	}
}

