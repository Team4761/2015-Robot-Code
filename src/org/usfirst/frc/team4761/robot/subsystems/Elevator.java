package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.ElevatorPIDOutput;
import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem that can move up an down on guide rails. Used for moving RCs up
 * and down, and putting them on top of piles.
 */
public class Elevator extends Subsystem {
	private static VictorSP speedController1 = Robot.robotMap.elevatorMotor1;
	private static VictorSP speedController2 = Robot.robotMap.elevatorMotor2;
	
	private static Encoder encoder = Robot.robotMap.elevatorQuadEncoder;
	
	private static ElevatorPIDOutput pidOutput = new ElevatorPIDOutput();
	
	private static PIDController PIDController = new PIDController(1.0, 0.0, 0.0, encoder, pidOutput); 
	
	public void initDefaultCommand() {
	}
	
	public void raise () {
		speedController1.set(-0.5);
		speedController2.set(-0.5);
	}
	
	public void lower () {
		speedController1.set(0.2);
		speedController2.set(0.2);
	}
	
	public void set (double speed) {
		speedController1.set(speed);
		speedController2.set(speed);
	}
	
	public void stop () {
		speedController1.set(0);
		speedController2.set(0);
	}

	public void setPosition(double position){
		PIDController.setSetpoint(position);
	}
	
	public void update(){ // I died inside.
		speedController1.set(pidOutput.getValue());
		speedController2.set(pidOutput.getValue());
	}
	
	public boolean isFinished(){
		return PIDController.onTarget();
	}
}

