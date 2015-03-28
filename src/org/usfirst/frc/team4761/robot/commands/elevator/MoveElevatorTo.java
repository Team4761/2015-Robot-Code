package org.usfirst.frc.team4761.robot.commands.elevator;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevatorTo extends Command {
	private int position = 0;
	private boolean atPosition = false;

    public MoveElevatorTo (int position) {
        requires(Robot.elevator);
        this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	atPosition = Robot.elevator.goTo(position);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return atPosition;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
