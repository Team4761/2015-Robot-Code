package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.ElevatorPIDOutput;
import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem that can move up an down on guide rails. Used for moving RCs up
 * and down, and putting them on top of piles.
 */
public class Elevator extends Subsystem {
	private VictorSP speedController1 = Robot.robotMap.elevatorMotor1;
	private VictorSP speedController2 = Robot.robotMap.elevatorMotor2;
	
	public Encoder encoder;
	
	private ElevatorPIDOutput pidOutput;// = new ElevatorPIDOutput();
	
	public PIDController PIdController;// = new PIDController(1.0, 0.0, 0.0, encoder, pidOutput); 
	public Elevator()
	{
		super();
		try
		{
			pidOutput = new ElevatorPIDOutput();
			encoder = Robot.robotMap.elevatorQuadEncoder;
			PIdController = new PIDController(1.0/10, 0.0, 0.0, encoder, pidOutput);
			PIdController.enable();
			PIdController.setPercentTolerance(10);
		}
		catch (Exception e)
		{
			System.out.println("Error creating obj");
			e.printStackTrace();
		}
	}
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
		PIdController.setSetpoint(position);
	}
	
	public void update(){ // I died inside.
		System.err.println(pidOutput.getValue() + "Setpoint: " + PIdController.getSetpoint() + " Encoder: " + encoder.getRaw());
		speedController1.set(pidOutput.getValue()/3);
		speedController2.set(pidOutput.getValue()/3);
	}
	
	public boolean isFinished(){
		return PIdController.onTarget();
	}
}

