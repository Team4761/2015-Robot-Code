package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.DriveLeft;
import org.usfirst.frc.team4761.robot.commands.GoToNextBarrel;
import org.usfirst.frc.team4761.robot.commands.LogToFile;
import org.usfirst.frc.team4761.robot.commands.MainConveyorForward;
import org.usfirst.frc.team4761.robot.commands.RaiseRcGrabber;
import org.usfirst.frc.team4761.robot.commands.SpinRcBaseOut;
import org.usfirst.frc.team4761.robot.commands.Stop;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
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
        addSequential(new Stop());
		addSequential(new RcPickUp());
		addParallel(new SpinRcBaseOut());
		addParallel(new DriveLeft());
		addSequential(new GoToNextBarrel());
		addSequential(new Stop());
		addSequential(new RaiseRcGrabber());
    }
}
