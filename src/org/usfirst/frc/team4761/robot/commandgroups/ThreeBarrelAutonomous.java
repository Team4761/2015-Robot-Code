package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.drivetrain.Drive;
import org.usfirst.frc.team4761.robot.commands.drivetrain.GoToBackEdgeOfBarrel;
import org.usfirst.frc.team4761.robot.commands.drivetrain.GoToNextBarrel;
import org.usfirst.frc.team4761.robot.commands.Stop;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MainConveyorForward;
import org.usfirst.frc.team4761.robot.commands.debug.LogToFile;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberUp;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseOut;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Picks up three RCs in a row.
 */
public class ThreeBarrelAutonomous extends CommandGroup {
    
    public ThreeBarrelAutonomous() {
    	addSequential(new ResetGyro(90));
    	addParallel(new LogToFile());
    	
    	addSequential(new SpinRcBaseOut());
    	addParallel(new MainConveyorForward());
    	addSequential(new RcPickUp());
		addParallel(new SpinRcBaseOut());
        addParallel(new Drive(0.15, 0, 90, 0, "ABSOLUTE"));
        addSequential(new GoToNextBarrel());
        addSequential(new GoToBackEdgeOfBarrel());
        addSequential(new Stop());
		addSequential(new RcPickUp());
		addParallel(new SpinRcBaseOut());
        addParallel(new Drive(0.15, 0, 90, 0, "ABSOLUTE"));
		addSequential(new GoToNextBarrel());
		addSequential(new GoToBackEdgeOfBarrel());
		addSequential(new Stop());
		addSequential(new RcGrabberUp());
    }
}
