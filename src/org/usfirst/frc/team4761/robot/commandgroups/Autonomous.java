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
import org.usfirst.frc.team4761.robot.commands.MainConveyorForward;
import org.usfirst.frc.team4761.robot.subsystems.MainConveyorBelt;

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
		addParallel(new LogToFile());
		//addSequential(new DriveToStep());
		//addParallel(new MainConveyorForward());
		//addParallel(new DriveAlongStep());
		
		//addParallel(new DriveBackAlongStep());
		
		addSequential(new GoToNextBarrel());
		addSequential(new GoToBackEdgeOfBarrel());
		addSequential(new RcPickUp());
		addSequential(new GoToNextBarrel());
		addSequential(new GoToBackEdgeOfBarrel());
		addSequential(new RcPickUp());
	}
}
