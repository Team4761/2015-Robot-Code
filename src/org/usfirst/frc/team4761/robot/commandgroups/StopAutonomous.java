package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.LogToFile;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StopAutonomous extends CommandGroup {
    
    public  StopAutonomous() {
        addParallel(new LogToFile());
    }
}
