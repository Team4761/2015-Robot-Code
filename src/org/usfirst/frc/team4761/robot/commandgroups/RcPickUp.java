package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberDown;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberUp;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseIn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command group to pick up an RC from the step.
 */
public class RcPickUp extends CommandGroup {
	
	public RcPickUp() {
		addSequential(new RcGrabberUp());
		addSequential(new SpinRcBaseIn());
		addSequential(new RcGrabberDown());
	}
}
