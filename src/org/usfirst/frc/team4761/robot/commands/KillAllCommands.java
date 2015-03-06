package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Tie up all subsystems, resulting in the termination of every command
 * currently running. We should probably find a better way to do this that does
 * not require all the subsystems to be hardcoded in.
 */
public class KillAllCommands extends Command {

	protected void initialize() {
		requires(Robot.driveTrain);
		requires(Robot.elevator);
		requires(Robot.liftConveyorBelt);
		requires(Robot.mainConveyorBelt);
		requires(Robot.plower);
		requires(Robot.rcGrabber);
		requires(Robot.rcGrabberBase);
	}

	protected void execute() {
	
	}
	
 	protected boolean isFinished() {
 		return true;
	}

	protected void end() {

	}
	protected void interrupted() {

 	}

}


