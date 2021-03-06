package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RcPickerUpperHold extends Command {
	private int button = 0;
	private int joystickNum;
	
	public RcPickerUpperHold (int button, int joystickNum) {
		requires(Robot.rcPickerUpper);
		this.button = button;
		this.joystickNum = joystickNum;
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.rcPickerUpper.close();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return !Robot.oi.joysticks[joystickNum].getRawButton(button);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.rcPickerUpper.open();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
