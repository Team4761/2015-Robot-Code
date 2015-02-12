package org.usfirst.frc.team4761.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4761.robot.commands.*;

public class RcPickUp extends CommandGroup {
	
	public RcPickUp() {
		addParallel(new DriveAlongStep());
		addSequential(new CheckForBarrel());
		addSequential(new RaiseRcGrabber());
		addSequential(new SpinRcBaseIn());
		addSequential(new LowerRcGrabber());
	}
}
