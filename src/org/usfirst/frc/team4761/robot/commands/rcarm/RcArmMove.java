package org.usfirst.frc.team4761.robot.commands.rcarm;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RcArmMove extends Command {
	boolean isServo = false;
	double move = 0, timeout;
	
	public RcArmMove (RcArmType type) {
		requires(Robot.rcArm);
		
    	switch (type) {
    		case WINCH_IN:
    			isServo = false;
    			move = 1;
    			break;
    		case WINCH_OUT:
    			isServo = false;
    			move = -1;
    			break;
    		case WINCH_STOP:
    			isServo = false;
    			move = 0;
    			break;
    		case SERVO:
    			isServo = true;
    			move = 90;
    			break;
    	}
    }
	
    public RcArmMove (RcArmType type, double timeout) {
		requires(Robot.rcArm);

    	switch (type) {
    		case WINCH_IN:
    			isServo = false;
    			move = 1;
    			break;
    		case WINCH_OUT:
    			isServo = false;
    			move = -1;
    			break;
    		case WINCH_STOP:
    			isServo = false;
    			move = 0;
    			break;
    		case SERVO:
    			isServo = true;
    			move = 90;
    			break;
    	}
    	
    	this.timeout = timeout;
    }
    
    public RcArmMove (double angle, double timeout) {
		requires(Robot.rcArm);

    	isServo = true;
    	this.move = angle;
    	
    	this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize () {
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute () {
    	if (isServo) {
    		Robot.rcArm.servoToAngle(move);
    	} else {
    		if (move == 1) {
    			Robot.rcArm.winchIn();
    		} else if (move == -1) {
    			Robot.rcArm.winchOut();
    		} else {
    			Robot.rcArm.winchStop();
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished () {
    	if (timeout != 0) {
    		return isTimedOut();
    	}
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end () {
    	if (!isServo) {
    		Robot.rcArm.winchStop();
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted () {
    	end();
    }
}