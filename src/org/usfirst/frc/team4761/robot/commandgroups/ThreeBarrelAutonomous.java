package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.GoToBackEdgeOfBarrel;
import org.usfirst.frc.team4761.robot.commands.GoToNextBarrel;
import org.usfirst.frc.team4761.robot.commands.Stop;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MainConveyorForward;
import org.usfirst.frc.team4761.robot.commands.debug.LogToFile;
import org.usfirst.frc.team4761.robot.commands.drivetrain.DriveLeft;
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
        addParallel(new DriveLeft());
        addSequential(new GoToNextBarrel());
        addSequential(new GoToBackEdgeOfBarrel());
        addSequential(new Stop());
		addSequential(new RcPickUp());
		addParallel(new SpinRcBaseOut());
		addParallel(new DriveLeft());
		addSequential(new GoToNextBarrel());
		addSequential(new GoToBackEdgeOfBarrel());
		addSequential(new Stop());
		addSequential(new RcGrabberUp());
    }
}
