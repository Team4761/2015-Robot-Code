package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.DriveAlongStep;
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
    	addSequential(new RcPickUp(true));
    	addSequential(new RcPickUp(true)); // Do it again for another barrel
    	// Go backwards
    	addSequential(new RcPickUp(false));
    	addSequential(new RcPickUp(false)); // Do it again for another barrel
    }
}