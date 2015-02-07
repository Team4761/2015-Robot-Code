package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.DriveForward;
import org.usfirst.frc.team4761.robot.commands.LogToFile;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous () {
    	addParallel(new LogToFile());
    	addSequential(new DriveForward());
    }
}