package org.usfirst.frc.team4761.robot.commands;

import java.io.File;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous () {
    	addParallel(new LogToFile(new File("/home/lvuser/autonomous.csv")));
    	addParallel(new DriveForward());
    	addSequential(new GetDistance());
        addSequential(new StopWheels());
    }
}