package org.usfirst.frc.team4761.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4761.robot.commands.LogToFile;

/**
 * The command that is run when the robot enters teleop mode.
 */
public class Teleop extends CommandGroup {
	
	public Teleop() {
		addParallel(new LogToFile());
		addSequential(new ResetGyro());
		addParallel(new DriveWithJoysticks());
	}
}
