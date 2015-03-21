package org.usfirst.frc.team4761.robot.commands.elevator;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AcceptTote1 extends Command {
	private boolean up = false;

	// up = false (down), true (up)
    public AcceptTote1 (boolean up) {
    	requires(Robot.elevator);
    	this.up = up;
    }

    // Called just before this Command runs the first time
    protected void initialize () {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (RobotMap.elevatorAcceptTote1.get() && !up) {
    		Robot.elevator.lower();
    	} else if (RobotMap.elevatorAcceptTote1.get() && up) {
    		Robot.elevator.raise();
    	} else {
    		Robot.elevator.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !RobotMap.elevatorAcceptTote1.get();
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
