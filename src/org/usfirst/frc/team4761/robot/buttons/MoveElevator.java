package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A command that moves the elevator either up or down.
 */
public class MoveElevator extends Command {
	boolean up = true;
/**
 * 
 * @param up Boolean that determines whether or not to move the {@link org.usfirst.frc.team4761.robot.subsystems.Elevator elevator} upwards (True)
 * or downwards (False);
 */
    public MoveElevator(boolean up) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	this.up = up;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = SmartDashboard.getNumber("Elevator Speed");
    	if (up) {
    		Robot.elevator.set(-speed);
    	} else {
    		Robot.elevator.set(speed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
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
