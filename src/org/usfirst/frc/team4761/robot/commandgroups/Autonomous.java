package org.usfirst.frc.team4761.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.DriveAlongStep;
import org.usfirst.frc.team4761.robot.commands.DriveBackAlongStep;
import org.usfirst.frc.team4761.robot.commands.GoToBackEdgeOfBarrel;
import org.usfirst.frc.team4761.robot.commands.GoToNextBarrel;
import org.usfirst.frc.team4761.robot.commands.DriveToStep;
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
	Logger log = new Logger("Autonomous");
	public Autonomous() {
		//TODO: Accommodate for other robots getting to RCs before us
		log.info("Started logging to file");
		addParallel(new LogToFile());
		log.info("Driving to step");
		addSequential(new DriveToStep());
		log.info("Adding parallel command drive along step.");
		addParallel(new DriveAlongStep());
		
		addParallel(new DriveBackAlongStep());
		
		log.info("Going to next barrel");
		addSequential(new GoToNextBarrel());
		log.info("Barrel detected. Going to back edge");
		addSequential(new GoToBackEdgeOfBarrel());
		log.info("Picking up");
		addSequential(new RcPickUp());
		log.info("Picked up");
		addSequential(new GoToNextBarrel());
		log.info("Barrel detected. Going to back edge");
		addSequential(new GoToBackEdgeOfBarrel());
		log.info("Picking up");
		addSequential(new RcPickUp());
		log.info("Ending Autonomous");
		addSequential(new ResetGyro());
	}
}
