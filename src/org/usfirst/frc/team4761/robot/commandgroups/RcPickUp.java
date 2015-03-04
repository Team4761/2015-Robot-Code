package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.rcgrabber.LowerRcGrabber;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RaiseRcGrabber;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseIn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command group to pick up an RC from the step.
 */
public class RcPickUp extends CommandGroup {
	
	public RcPickUp() {
		addSequential(new RaiseRcGrabber());
		addSequential(new SpinRcBaseIn());
		addSequential(new LowerRcGrabber());
	}
}
