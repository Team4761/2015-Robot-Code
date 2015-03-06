package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.drivetrain.Drive;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseIn;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.SpinRcBaseOut;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PushToAuto extends CommandGroup {
    
    public  PushToAuto() {
    	addSequential(new ResetGyro());
    	addSequential(new RcPickUp());
    	addParallel(new SpinRcBaseOut());
    	addSequential(new Drive(0, -0.5, 0, 3, "ABSOLUTE"));
    }
}
