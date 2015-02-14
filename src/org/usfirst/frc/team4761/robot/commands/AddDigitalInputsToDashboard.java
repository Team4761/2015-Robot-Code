package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

public class AddDigitalInputsToDashboard extends Command {
	DigitalInput[] inputs = new DigitalInput[10];
	protected void initialize() {
	for (int i = 0; i < 10; i++)
	  inputs[i] = new DigitalInput(i);
	}

	protected void execute() {
		for (int i = 0; i < 10; i++)
		  SmartDashboard.put("DI_" + i, inputs[i].get());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	

}
