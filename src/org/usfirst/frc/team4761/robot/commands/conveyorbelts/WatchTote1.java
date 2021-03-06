package org.usfirst.frc.team4761.robot.commands.conveyorbelts;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WatchTote1 extends Command {
	DigitalInput di = RobotMap.elevatorBottom;
	private boolean passingBeam = false, toteOnElevator = false;

    public WatchTote1() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	passingBeam = false;
    	toteOnElevator = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!RobotMap.breakBeamClear.get() && !passingBeam) {
    		passingBeam = true;
    	}
    	
    	if (!RobotMap.breakBeamElevatorBegin.get() && !toteOnElevator) {
    		toteOnElevator = true;
    	}
    	
    	if (toteOnElevator) {
    		if (!di.get()) {
    			Robot.elevator.stop();
    		} else {
    			Robot.elevator.lower();
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.breakBeamClear.get() && passingBeam;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
