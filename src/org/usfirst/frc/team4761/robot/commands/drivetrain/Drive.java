package org.usfirst.frc.team4761.robot.commands.drivetrain;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command to make the {@link org.usfirst.frc.team4761.robot.subsystems.
 * DriveTrain drive train} drive in a specified direction. You can either
 * specify values manually yourself or simply use one of the prebuilt
 * drivemodes defined by {@link DriveType}.
 */
public class Drive extends Command {

	Double x, y, rotate;
	Float time;
	String type;
	
	// Type can be PID or ABSOLUTE
    public Drive (double x, double y, double rotate, float time, String type) {
    	this.x = x;
    	this.y = y;
    	this.rotate = rotate;
    	this.time = time;
    	this.type = type;
    	requires(Robot.driveTrain);
    }
    
    public Drive (DriveType type){
    	switch (type) {
	    	case LEFT:
	    		x = -.15;
	    		y = 0.0;
	    		rotate = 0.0;
	    		break;
	    	case RIGHT:
	    		x = .15;
	    		y = 0.0;
	    		rotate = 0.0;
	    		break;
	    	case FORWARD:
	    		x = 0.0;
	    		y = .15;
	    		rotate = 0.0;
	    		break;
	    	case BACKWARD:
	    		x = 0.0;
	    		y = .15;
	    		rotate = 0.0;
	    		break;
    	}
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute () {
    	if (type.equals("PID")) {
    		Robot.driveTrain.drive(x, y, rotate);
    	} else {
    		Robot.driveTrain.driveAbsolute(x, y, rotate);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished () {
        if (time != null && time != 0) {
        	return isTimedOut();
        } else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
