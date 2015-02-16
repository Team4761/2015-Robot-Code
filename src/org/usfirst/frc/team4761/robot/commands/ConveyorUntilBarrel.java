package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConveyorUntilBarrel extends Command { // TODO: Fix this disgusting naming.
	
    public ConveyorUntilBarrel(){
    	requires(Robot.mainConveyorBelt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mainConveyorBelt.go(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.mainConveyorBelt.getDistance() < 5); // Distance sensor returns less than 5 cm, must be a barrel!
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mainConveyorBelt.go(0); // Stop it.
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
