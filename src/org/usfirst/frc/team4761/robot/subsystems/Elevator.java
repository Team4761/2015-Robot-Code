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
	private static Encoder encoder = RobotMap.encoder;
	
	public void initDefaultCommand() {
	}
	
	public void raise () {
		speedController1.set(-0.65);
		speedController2.set(-0.65);
	}
	
	public void lower () {
		speedController1.set(SmartDashboard.getNumber("Elevator Speed: "));
		speedController2.set(SmartDashboard.getNumber("Elevator Speed: "));
	}
	
	public void set (double speed) {
		speedController1.set(speed);
		speedController2.set(speed);
	}
	
	public boolean goTo (double position) {
		if (encoder.get() > position) {
			if (encoder.get() > position + 50 || encoder.get() < position - 50) {
				stop();
				return true;
			} else {
				raise();
			}
		} else {
			if (encoder.get() > position + 50 || encoder.get() < position - 50) {
				stop();
				return true;
			} else {
				lower();
			}
		}
		
		return false;
	}
	
	public void stop () {
		speedController1.set(0);
		speedController2.set(0);
	}
}

