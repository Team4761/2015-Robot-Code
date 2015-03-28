package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.GoToBackEdgeOfBarrel;
import org.usfirst.frc.team4761.robot.commands.GoToNextBarrel;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MainConveyorForward;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RaiseRcGrabber;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseIn;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseOut;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TwoBarrelAutonomous extends CommandGroup {
    
    public TwoBarrelAutonomous (int angle) {
    	addSequential(new ResetGyro(angle));
    	addParallel(new MainConveyorForward());
    	// Drive
    	addSequential(new RcPickUp());
    	addSequential(new GoToNextBarrel());
        addSequential(new GoToBackEdgeOfBarrel());
        // Stop Driving
    	addSequential(new SpinRcBaseOut());
    	addSequential(new RaiseRcGrabber());
    	addParallel(new SpinRcBaseIn());
    }
}