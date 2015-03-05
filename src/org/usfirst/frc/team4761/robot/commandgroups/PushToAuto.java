package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.drivetrain.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PushToAuto extends CommandGroup {
    
    public  PushToAuto() {
    	addSequential(new ResetGyro());
    	addSequential(new Drive(0, 0.5, 0, 5));
    }
}
