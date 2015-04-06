package org.usfirst.frc.team4761.robot.commands.debug;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Adds the first ten digital inputs to Smart Dashboard.
 */
public class AddDigitalInputsToDashboard extends Command {
	DigitalInput[] inputs = new DigitalInput[10];
	protected void initialize() {
		for (int i = 0; i < 10; i++) {
			inputs[i] = new DigitalInput(i);
		}
	}

	protected void execute() {
		for (int i = 0; i < 10; i++) {
		  SmartDashboard.putBoolean("DI_" + i, inputs[i].get());
		}
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
