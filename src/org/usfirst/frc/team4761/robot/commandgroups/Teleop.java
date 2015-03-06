package org.usfirst.frc.team4761.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4761.robot.buttons.Rumble;
import org.usfirst.frc.team4761.robot.commands.ControlLeds;
import org.usfirst.frc.team4761.robot.commands.LogToFile;

/**
 * The command that is run when the robot enters teleop mode.
 */
public class Teleop extends CommandGroup {
	
	public Teleop() {
		addParallel(new LogToFile());
		addParallel(new ControlLeds());
		addParallel(new Rumble(1, 1)); // Random numbers just for testing
		//addParallel(new DriveWithJoysticks());
	}
}