package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.ToAutoZone;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToAutoZone extends CommandGroup {
    
    public  DriveToAutoZone() {
    	addSequential(new ToAutoZone());
    }
}
