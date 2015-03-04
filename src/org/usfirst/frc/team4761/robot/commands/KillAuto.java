package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class KillAuto extends Command {

	protected void initialize() {
		if (Robot.robot.autonomousCommand != null)
			Robot.robot.autonomousCommand.cancel();
		Robot.robot.teleop.start();
	}
	protected void execute() {
		
	}
	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		
	}
	protected void interrupted() {
		
	}

}
