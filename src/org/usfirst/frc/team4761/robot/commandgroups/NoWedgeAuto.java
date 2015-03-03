package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.GoToBackEdgeOfBarrel;
import org.usfirst.frc.team4761.robot.commands.GoToNextBarrel;
import org.usfirst.frc.team4761.robot.commands.LogToFile;
import org.usfirst.frc.team4761.robot.commands.Stop;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MainConveyorForward;
import org.usfirst.frc.team4761.robot.commands.drivetrain.DriveLeft;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RaiseRcGrabber;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseOut;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous mode where the wedge is not deployed.
 */
public class NoWedgeAuto extends CommandGroup {
    
    public NoWedgeAuto() {
    	addSequential(new ResetGyro());
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
		addSequential(new RaiseRcGrabber());
    }
}
