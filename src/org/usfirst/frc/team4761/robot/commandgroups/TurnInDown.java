package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.rcgrabber.LowerRcGrabber;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseIn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Turn the RC lifter in and bring it down.
 */
public class TurnInDown extends CommandGroup { 
    public  TurnInDown() {
    	addSequential(new SpinRcBaseIn());
    	addSequential(new LowerRcGrabber());
    }
}
