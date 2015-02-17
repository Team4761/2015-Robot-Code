package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.DriveLeft;
import org.usfirst.frc.team4761.robot.commands.GoToNextBarrel;
import org.usfirst.frc.team4761.robot.commands.MainConveyorForward;
import org.usfirst.frc.team4761.robot.commands.RaiseRcGrabber;
import org.usfirst.frc.team4761.robot.commands.SpinRcBaseOut;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class NoWedgeAuto extends CommandGroup {
    
    public  NoWedgeAuto() {
    	addParallel(new SpinRcBaseOut());
    	addParallel(new MainConveyorForward());
    	addSequential(new RcPickUp());
        addParallel(new DriveLeft());
        addSequential(new GoToNextBarrel());
		addSequential(new RcPickUp());
		addSequential(new GoToNextBarrel());
		addSequential(new RaiseRcGrabber());
    }
}
