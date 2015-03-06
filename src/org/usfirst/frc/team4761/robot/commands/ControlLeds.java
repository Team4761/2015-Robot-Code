package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sends I2C transmissions to the Arduino that turns the LEDs on and off in a
 * pre-programmed pattern.
 */
public class ControlLeds extends Command {
	int i;
	
    public ControlLeds() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(3);
    	RobotMap.arduino.transaction(new byte[]{71}, 1, null, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	i = 72;
    	if (isTimedOut()) {
    		i++;
        	RobotMap.arduino.transaction(new byte[]{(byte) i}, 1, null, 0);
        	setTimeout(3);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (i >= 89) {
    		return true;
    	}
    	
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
