package org.usfirst.frc.team4761.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4761.robot.commands.LEDs;
import org.usfirst.frc.team4761.robot.commands.LogToFile;
import org.usfirst.frc.team4761.robot.commands.drivetrain.DriveWithJoysticks;

/**
 * The command that is run when the robot enters teleop mode.
 */
public class Teleop extends CommandGroup {
	
	public Teleop() {
		addParallel(new LogToFile());
		addParallel(new LEDs());
		//addParallel(new DriveWithJoysticks());
	}
}