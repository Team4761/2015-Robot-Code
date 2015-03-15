package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command that moves the elevator either up or down.
 */
public class LowerElevator extends Command {
	private int button = 0;
	private int joystickNum;
	
/**
 * 
 * @param up Boolean that determines whether or not to move the {@link org.usfirst.frc.team4761.robot.subsystems.Elevator elevator} upwards (True)
 * or downwards (False);
 */
    public LowerElevator (int button, int joystickNum) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	this.button = button;
    	this.joystickNum = joystickNum;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.lower();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return !Robot.oi.joysticks[joystickNum].getRawButton(button) || !RobotMap.elevatorBottom.get();
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
