package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4761.robot.commands.LogToFile;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The command that is run when the robot enters teleop mode.
 */
public class Teleop extends CommandGroup {
    
    public  Teleop () {
    	addParallel(new LogToFile());
    	addParallel(new DriveWithJoysticks());
    }
}