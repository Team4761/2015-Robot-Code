package org.usfirst.frc.team4761.robot.commands.conveyorbelts;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConveyorPassBarrel extends Command {

    public ConveyorPassBarrel() {
    	requires(Robot.mainConveyorBelt);
    	requires(Robot.liftConveyorBelt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mainConveyorBelt.go(1);
    	Robot.liftConveyorBelt.go(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.mainConveyorBelt.getDistance() > 50); // The distance is greater than 50 the barrel must be gone! TODO: Get a better and more exact number to compare to.
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mainConveyorBelt.go(0);
    	Robot.liftConveyorBelt.go(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
