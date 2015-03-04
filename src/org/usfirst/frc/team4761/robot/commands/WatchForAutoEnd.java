package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WatchForAutoEnd extends Command{

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return Robot.robot.autoDone;
	}

	@Override
	protected void end() {
		if (Robot.robot.autonomousCommand != null)
			Robot.robot.autonomousCommand.cancel();
		Robot.robot.teleop.start();	
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}
