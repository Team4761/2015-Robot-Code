package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.debug.LogToFile;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous for debugging stuff. Feel free to delete whatever is currently in
 * here. If you put something in here, do not expect it to stay.
 */
public class DebugAutonomous extends CommandGroup {
	
    public DebugAutonomous() {
    	addParallel(new LogToFile());
    	//addParallel(new ReadDistanceSensor());
    }
}