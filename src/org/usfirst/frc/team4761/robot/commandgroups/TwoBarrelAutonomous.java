package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.drivetrain.GoToBackEdgeOfBarrel;
import org.usfirst.frc.team4761.robot.commands.drivetrain.GoToNextBarrel;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberMove;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberType;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MainConveyorForward;

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
    	addSequential(new RcGrabberMove(RcGrabberType.OUT));
    	addSequential(new RcGrabberMove(RcGrabberType.UP, 1.2));
    	addParallel(new RcGrabberMove(RcGrabberType.IN));
    }
}