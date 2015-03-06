package org.usfirst.frc.team4761.robot.commandgroups;

import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.GoToNextBarrel;
import org.usfirst.frc.team4761.robot.commands.LogToFile;
import org.usfirst.frc.team4761.robot.commands.Stop;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MainConveyorForward;
import org.usfirst.frc.team4761.robot.commands.drivetrain.DriveAlongStep;

import edu.wpi.first.wpilibj.command.CommandGroup;

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
		addSequential(new ResetGyro());
		
		addParallel(new LogToFile());
		
		//addParallel(new SpinRcBaseOut());
		addParallel(new MainConveyorForward());
		/*addSequential(new DriveToStep());
		addSequential(new EngageTotes());
		addSequential(new Rotate());
		addSequential(new RotateN());
		addSequential(new StayFlat());
		// Make room for plow
		addSequential(new PlowExtend()); // Tested*/
		addParallel(new DriveAlongStep());
		addSequential(new GoToNextBarrel()); // Tested
		addSequential(new Stop());
		addSequential(new RcPickUp()); // Tested
		//addSequential(new GoToNextBarrel()); // Tested
		//addSequential(new Stop());
		//addSequential(new RcPickUp()); // Tested
	}
}
