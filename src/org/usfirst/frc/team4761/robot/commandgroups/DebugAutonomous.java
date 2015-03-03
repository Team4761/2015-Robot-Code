package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.debug.ReadDi0Value;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * An autonomous mode for debugging. Feel free to add/remove stuff.
 */
public class DebugAutonomous extends CommandGroup {
    
    public  DebugAutonomous() {
    	addSequential(new ReadDi0Value());
    }
}
