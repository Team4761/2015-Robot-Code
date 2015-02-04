package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous () {
    	addParallel(new LogToFile("/home/lvuser/log.txt"));
    	//addParallel(new DriveForward());
    	addSequential(new GetDistance());
        addSequential(new StopWheels());
    }
}