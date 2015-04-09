package org.usfirst.frc.team4761.robot.commands.rcarm;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RcArmMove extends Command {
	String moveType = "SERVO";
	double move = 0, timeout;
	
	public RcArmMove (RcArmType type) {
		requires(Robot.rcArm);
		
    	switch (type) {
    		case WINCH_IN:
    			moveType = "WINCH";
    			move = 1;
    			break;
    		case WINCH_OUT:
    			moveType = "WINCH";
    			move = -1;
    			break;
    		case WINCH_STOP:
    			moveType = "WINCH";
    			move = 0;
    			break;
    		case SERVO:
    			moveType = "SERVO";
    			move = 90;
    			break;
    		case EXTEND:
    			moveType = "PNEUMATIC";
    			move = 1;
    			break;
    		case RETRACT:
    			moveType = "PNEUMATIC";
    			move = -1;
    			break;
    		case OFF:
    			moveType = "PNEUMATIC";
    			move = 0;
    			break;
    	}
    }
	
    public RcArmMove (RcArmType type, double timeout) {
		requires(Robot.rcArm);

		switch (type) {
			case WINCH_IN:
				moveType = "WINCH";
				move = 1;
				break;
			case WINCH_OUT:
				moveType = "WINCH";
				move = -1;
				break;
			case WINCH_STOP:
				moveType = "WINCH";
				move = 0;
				break;
			case SERVO:
				moveType = "SERVO";
				move = 255;
				break;
			case EXTEND:
    			moveType = "PNEUMATIC";
    			move = 1;
    			break;
    		case RETRACT:
    			moveType = "PNEUMATIC";
    			move = -1;
    			break;
    		case OFF:
    			moveType = "PNEUMATIC";
    			move = 0;
    			break;
		}
    	
    	this.timeout = timeout;
    }
    
    public RcArmMove (double angle, double timeout) {
		requires(Robot.rcArm);

		moveType = "SERVO";
    	this.move = angle;
    	
    	this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize () {
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute () {
    	if (moveType.equals("SERVO")) {
    		Robot.rcArm.servoToAngle(move);
    	} else if (moveType.equals("WINCH")) {
    		if (move == 1) {
    			Robot.rcArm.winchIn();
    		} else if (move == -1) {
    			Robot.rcArm.winchOut();
    		} else {
    			Robot.rcArm.winchStop();
    		}
    	} else {
    		if (move == 1) {
    			Robot.rcArm.extendPusher();
    		} else if (move == -1) {
    			Robot.rcArm.retractPusher();
    		} else {
    			Robot.rcArm.pusherOff();
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
    	if (!moveType.equals("WINCH")) {
    		Robot.rcArm.winchStop();
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted () {
    	end();
    }
}