package org.usfirst.frc.team4761.robot.commandgroups;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4761.robot.commands.*;

/**
 * Command group to pick up an RC from the step.
 */
public class RcPickUp extends CommandGroup {
	Command moveConveyor = new MainConveyorForward();
	
	public RcPickUp() {
		addSequential(new LowerRcGrabber());
		addSequential(new RaiseRcGrabber());
		addParallel(moveConveyor);
		addSequential(new SpinRcBaseIn());
		addSequential(new LowerRcGrabber());
		addSequential(new SpinRcBaseOut());
		moveConveyor.cancel(); // Stop moving conveyor belt
	}
}
