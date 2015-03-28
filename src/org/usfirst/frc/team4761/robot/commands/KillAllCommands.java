package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Tie up all subsystems, resulting in the termination of every command
 * currently running. 
 */
public class KillAllCommands extends Command {
	public KillAllCommands () {
		requires(Robot.elevator);
		requires(Robot.liftConveyorBelt);
		requires(Robot.mainConveyorBelt);
		//requires(Robot.rcGrabber);
		requires(Robot.rcGrabberBase);
	}
	
	protected void initialize() {
		
	}

	protected void execute() {
		Robot.elevator.stop();
		Robot.liftConveyorBelt.stop();
		Robot.mainConveyorBelt.stop();
		Robot.rcGrabberBase.stop();
	}
	
 	protected boolean isFinished() {
 		return true;
	}

	protected void end() {

	}
	protected void interrupted() {

 	}

}


