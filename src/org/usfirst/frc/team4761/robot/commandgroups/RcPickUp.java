package org.usfirst.frc.team4761.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4761.robot.commands.*;

public class RcPickUp extends CommandGroup {
	
	public RcPickUp(boolean forward) {
		addParallel(new DriveAlongStep(forward));
		addSequential(new CheckForBarrel());
		addSequential(new RaiseRcGrabber());
		addSequential(new SpinRcBaseIn());
		addSequential(new LowerRcGrabber());
	}
}
