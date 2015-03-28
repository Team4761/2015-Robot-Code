package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the lift conveyor forwards until a button is no longer pressed at full speed.
 */
public class LiftConveyorForward extends Command {
	private int button = 0;
	private int joystickNum = 0;

    public LiftConveyorForward (int button, int joystickNum) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.liftConveyorBelt);
    	this.button = button;
    	this.joystickNum = joystickNum;
    }
	
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.joysticks[1].getRawAxis(4) < 0.05) {
			Robot.liftConveyorBelt.go(0.65);
		} else {
			Robot.liftConveyorBelt.forward();
		}
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return !Robot.oi.joysticks[joystickNum].getRawButton(button);
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.liftConveyorBelt.stop();
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
