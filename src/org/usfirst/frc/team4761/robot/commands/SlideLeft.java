package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SlideLeft extends Command {

    public SlideLeft() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(100);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.autoDrive(0, 0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
