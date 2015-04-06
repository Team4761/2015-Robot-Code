package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.drivetrain.Drive;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberUp;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseIn;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseOut;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * An autonomous in which the robot drives to the auto zone and picks up a barrel on the way.
 */
public class PushToAuto extends CommandGroup {
    
    public  PushToAuto (int angle) {
    	addSequential(new ResetGyro(angle));
    	addSequential(new SpinRcBaseOut());
    	addSequential(new RcGrabberUp());
    	addParallel(new SpinRcBaseIn());
    	addSequential(new Drive(0, -0.5, 0, 6, "ABSOLUTE"));
    }
}