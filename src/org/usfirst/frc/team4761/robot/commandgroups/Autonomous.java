package org.usfirst.frc.team4761.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4761.robot.commands.CheckForBarrel;
import org.usfirst.frc.team4761.robot.commands.DriveAlongStep;
import org.usfirst.frc.team4761.robot.commands.DriveForward;
import org.usfirst.frc.team4761.robot.commands.LogToFile;

/**
 * Command group that is run automatically when the robot enters autonomous
 * mode. This year, it will drive to the line of RCs, grab 'em, and put them on
 * the {@link org.usfirst.frc.team4761.robot.subsystems.LowerConveyorBelt
 * lower conveyor belt}, all while plowing totes out of the way with the
 * {@link org.usfirst.frc.team4761.robot.subsystems.Plower plower}. There is a
 * discussion on <a href=https://github.com/Team4761/2015-Robot-Code/issues/1>
 * GitHub</a> about this command.
 */
public class Autonomous extends CommandGroup {
	
	public Autonomous() {
		addParallel(new LogToFile());
		addSequential(new DriveForward());
		
		addParallel(new DriveAlongStep(true));
		addSequential(new CheckForBarrel());
		
		addSequential(new RcPickUp());
		
		addParallel(new DriveAlongStep(true));
		addSequential(new CheckForBarrel());
		
		addSequential(new RcPickUp()); // Do it again for another barrel
		// Go backwards
		
		addParallel(new DriveAlongStep(false));
		addSequential(new CheckForBarrel());
		
		addSequential(new RcPickUp());
		
		addParallel(new DriveAlongStep(false));
		addSequential(new CheckForBarrel());
		
		addSequential(new RcPickUp()); // Do it again for another barrel
	}
}
