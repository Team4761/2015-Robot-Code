package org.usfirst.frc.team4761.robot.commands.debug;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestCommand extends Command {
	private int button = 0;
	private int joystickNum;
	
	public TestCommand (int button, int joystickNum) {
		this.button = button;
		this.joystickNum = joystickNum;
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Initialized!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Running");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.oi.joysticks[joystickNum].getPOV() != button) {
    		return true;
    	} else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Stopped");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
