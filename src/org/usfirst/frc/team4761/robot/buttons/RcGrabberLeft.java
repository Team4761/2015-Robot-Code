package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the RC Grabber left until the limit switch is hit.
 */
public class RcGrabberLeft extends Command {
	private int button = 0;
	private int joystickNum;

    public RcGrabberLeft (int button, int joystickNum) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.rcGrabberBase);
    	this.button = button;
    	this.joystickNum = joystickNum;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!Robot.rcGrabberBase.inTriggered()) {
    		Robot.rcGrabberBase.goIn();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return !Robot.oi.joysticks[joystickNum].getRawButton(button) || Robot.rcGrabberBase.inTriggered();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.rcGrabberBase.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
