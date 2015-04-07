package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberMove;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberType;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command group to pick up an RC from the step.
 */
public class RcPickUp extends CommandGroup {
	
	public RcPickUp() {
		addSequential(new RcGrabberMove(RcGrabberType.UP, 1.2));
		addSequential(new RcGrabberMove(RcGrabberType.IN));
		addSequential(new RcGrabberMove(RcGrabberType.DOWN, 1));
	}
}
