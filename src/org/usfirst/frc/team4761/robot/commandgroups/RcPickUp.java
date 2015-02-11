package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.CheckForBarrel;
import org.usfirst.frc.team4761.robot.commands.DriveAlongStep;
import org.usfirst.frc.team4761.robot.commands.RaiseRcGrabber;
import org.usfirst.frc.team4761.robot.commands.LowerRcGrabber;
import org.usfirst.frc.team4761.robot.commands.SpinRcBaseIn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RcPickUp extends CommandGroup {
    
    public  RcPickUp (boolean forward) {
    	addParallel(new DriveAlongStep(forward));
    	addSequential(new CheckForBarrel());
    	addSequential(new RaiseRcGrabber());
    	addSequential(new SpinRcBaseIn());
    	addSequential(new LowerRcGrabber());
    }
}
