package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.rcgrabber.LowerRcGrabber;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseIn;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseOut;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Spins the RC hook in and lowers it.
 */
public class LazyButton extends CommandGroup {
    
    public LazyButton() {
    	addSequential(new SpinRcBaseIn());
    	addSequential(new LowerRcGrabber());
    	//addSequential(new SpinRcBaseOut());
    }
}
