package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftConveyorDown extends Command {

    public LiftConveyorDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.liftConveyorBelt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.liftConveyorBelt.go(-0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return !Robot.oi.buttons.getRawButton(5);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.liftConveyorBelt.go(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
