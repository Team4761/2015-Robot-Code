package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command that moves the elevator either up or down.
 */
public class MoveElevator extends Command {
	boolean up = true;
	double speed = 0.3;
	
/**
 * 
 * @param up Boolean that determines whether or not to move the {@link org.usfirst.frc.team4761.robot.subsystems.Elevator elevator} upwards (True)
 * or downwards (False);
 */
    public MoveElevator(boolean up, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	this.up = up;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (up) {
    		Robot.elevator.set(-speed);
    	} else {
    		Robot.elevator.set(speed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (up) {
    		return !Robot.oi.buttons.getRawButton(6);
    	} else {
    		//return !Robot.oi.buttons.getRawButton(5) || !RobotMap.elevatorDI.get();
    		return !Robot.oi.buttons.getRawButton(5);
    	}
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
