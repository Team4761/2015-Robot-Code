package org.usfirst.frc.team4761.robot.commands;

import java.io.File;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Teleop extends CommandGroup {
    
    public  Teleop () {
    	addParallel(new LogToFile(new File("/home/lvuser/teleop.csv")));
    	addParallel(new DriveWithJoysticks());
    }
}
