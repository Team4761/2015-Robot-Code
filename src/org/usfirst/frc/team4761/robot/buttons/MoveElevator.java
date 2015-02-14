package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevator extends Command {
	boolean up = true;

    public MoveElevator(boolean up) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	this.up = up;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(0.02);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (up) {
    		Robot.elevator.raise();
    	} else {
    		Robot.elevator.lower();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
