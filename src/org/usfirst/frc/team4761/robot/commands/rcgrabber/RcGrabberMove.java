package org.usfirst.frc.team4761.robot.commands.rcgrabber;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RcGrabberMove extends Command {
	boolean isPneumatic = false;
	int movement = 0;
	double timeout = 0;

	public RcGrabberMove (RcGrabberType type) {
        switch (type) {
        	case IN:
                requires(Robot.rcGrabberBase);
                
        		isPneumatic = false;
        		movement = 1;
        		break;
        	case OUT:
                requires(Robot.rcGrabberBase);
                
        		isPneumatic = false;
        		movement = -1;
        		break;
        	case STOP:
                requires(Robot.rcGrabberBase);

                isPneumatic = false;
        		movement = 0;
        		break;
        	case UP:
                requires(Robot.rcGrabber);
        		
        		isPneumatic = true;
        		movement = 1;
        		break;
        	case DOWN:
                requires(Robot.rcGrabber);
        		
        		isPneumatic = true;
        		movement = -1;
        		break;
        	case OFF:
                requires(Robot.rcGrabber);
                
                isPneumatic = true;
                movement = 0;
        }
    }
	
    public RcGrabberMove (RcGrabberType type, double timeout) {
        switch (type) {
        	case IN:
                requires(Robot.rcGrabberBase);
                
        		isPneumatic = false;
        		movement = 1;
        		break;
        	case OUT:
                requires(Robot.rcGrabberBase);
                
        		isPneumatic = false;
        		movement = -1;
        		break;
        	case STOP:
                requires(Robot.rcGrabberBase);

                isPneumatic = false;
        		movement = 0;
        		break;
        	case UP:
                requires(Robot.rcGrabber);
        		
        		isPneumatic = true;
        		movement = 1;
        		break;
        	case DOWN:
                requires(Robot.rcGrabber);
        		
        		isPneumatic = true;
        		movement = -1;
        		break;
        	case OFF:
                requires(Robot.rcGrabber);
                
                isPneumatic = true;
                movement = 0;
        }
        
        this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize () {
    	setTimeout(this.timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isPneumatic) {
    		if (movement == 1) {
    			Robot.rcGrabber.set(DoubleSolenoid.Value.kReverse);
    		} else if (movement == -1) {
    			Robot.rcGrabber.set(DoubleSolenoid.Value.kForward);
    		} else {
    			Robot.rcGrabber.set(DoubleSolenoid.Value.kOff);
    		}
    	} else {
    		if (movement == 1) {
    			Robot.rcGrabberBase.goIn();
    		} else if (movement == -1) {
    			Robot.rcGrabberBase.goOut();
    		} else {
    			Robot.rcGrabberBase.stop();
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (this.timeout != 0) {
    		return isTimedOut();
    	}
    	
    	if (!isPneumatic) {
    		if (movement == 1) {
    			return Robot.rcGrabberBase.inTriggered();
    		} else {
    			return Robot.rcGrabberBase.outTriggered();
    		}
    	}
    	
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (!isPneumatic) {
    		Robot.rcGrabberBase.stop();
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
