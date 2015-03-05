package org.usfirst.frc.team4761.robot.commands.elevator;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToPosition extends Command {

	double position;
	
    public GoToPosition(double pos) {
        requires(Robot.elevator);
        position = pos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.setPosition(position);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.update();
    	System.out.println("Stopped: " + (position==Robot.elevator.encoder.getRaw()));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(position-Robot.elevator.encoder.getRaw()) < 10;
        // return Robot.elevator.isFinished();
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
