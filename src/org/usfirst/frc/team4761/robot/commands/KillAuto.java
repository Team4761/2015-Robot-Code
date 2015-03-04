package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class KillAuto extends Command {

	protected void initialize() {
		Robot.robot.autoDone = true;
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
