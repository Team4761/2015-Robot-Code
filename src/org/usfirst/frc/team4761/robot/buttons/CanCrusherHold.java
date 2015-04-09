package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggles the RC Grabber position up or down.
 */
public class CanCrusherHold extends Command {
	private int button = 0;
	private int joystickNum;
	
	public CanCrusherHold (int button, int joystickNum) {
		this.button = button;
		this.joystickNum = joystickNum;
		
		requires(Robot.canCrusher);
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.canCrusher.extend();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return !Robot.oi.joysticks[joystickNum].getRawButton(button);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.canCrusher.retract();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
