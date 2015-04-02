package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.LogToFile;
import org.usfirst.frc.team4761.robot.commands.PushToSmartDashboard;
import org.usfirst.frc.team4761.robot.commands.drivetrain.DriveWithJoysticks;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The command that is run when the robot enters teleop mode.
 */
public class Teleop extends CommandGroup {
	
	public Teleop() {
		addParallel(new LogToFile());
		addParallel(new PushToSmartDashboard());
		addParallel(new DriveWithJoysticks());
	}
}