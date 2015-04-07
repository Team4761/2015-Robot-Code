package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberMove;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberType;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Spins the RC hook in and lowers it.
 */
public class LazyButton extends CommandGroup {
    
    public LazyButton() {
    	addSequential(new RcGrabberMove(RcGrabberType.IN));
    	addSequential(new RcGrabberMove(RcGrabberType.DOWN, 1));
    	//addSequential(new SpinRcBaseOut());
    }
}
