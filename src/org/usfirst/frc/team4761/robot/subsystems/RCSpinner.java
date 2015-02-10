package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class RCSpinner extends PIDSubsystem {

	public Double outside = 0.0; // TODO: Get correct setpoint.
	public Double inside = 1.0;  // TODO: Get correct setpoint.
	
	AnalogInput potentiometer = RobotMap.rcPot;
	VictorSP spinner = RobotMap.spinner;
	
    // Initialize your subsystem here
    public RCSpinner() {
    	super("RCSpinner", 0.0, 0.0, 0.0);
    	setAbsoluteTolerance(.05);
    	setSetpoint(0);
    	getPIDController().setContinuous();
    	enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
    	return potentiometer.getAverageVoltage();
    }
    
    protected void usePIDOutput(double output) {
    	spinner.set(output);
    }
    
    public Boolean isDone(){
    	return (Math.abs(Robot.rcSpinner.getSetpoint() - Robot.rcSpinner.getPosition()) < .05);
    }
}
