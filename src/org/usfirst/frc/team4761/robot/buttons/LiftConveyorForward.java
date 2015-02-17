package org.usfirst.frc.team4761.robot.buttons;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4761.robot.Robot;

/**
 *
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
		Robot.liftConveyorBelt.go(1);
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return !Robot.oi.joysticks[joystickNum].getRawButton(button);
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