package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RcSpinIn extends Command {
    public RcSpinIn() {
    	requires(Robot.rcSpinner);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.rcSpinner.setSetpoint(Robot.rcSpinner.inside);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.rcSpinner.isDone();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
