package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.debug.ReadDi0Value;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DebugAutonomous extends CommandGroup {
    
    public  DebugAutonomous() {
    	addSequential(new ReadDi0Value());
    }
}
