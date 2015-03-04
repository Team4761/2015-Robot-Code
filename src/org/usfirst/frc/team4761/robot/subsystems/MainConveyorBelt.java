package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Conveyor belt for moving RCs through the robot. Uses a Talon SRX speed
 * controller.
 */
public class MainConveyorBelt extends Subsystem {
	private static Talon speedController = Robot.robotMap.mainConveyorBeltMotor;
	private static MediumDistanceSensor sensor = Robot.robotMap.elevatorDistanceSensor;
	
	public void initDefaultCommand() {
	}
	
	public void go(double speed) {
		speedController.set(speed);
	}
	
	public double getDistance(){
		return sensor.getDistance();
	}
}
