package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.LogToFile;
import org.usfirst.frc.team4761.robot.commands.Wait;
import org.usfirst.frc.team4761.robot.commands.drivetrain.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StopAutonomous extends CommandGroup {
    
    public  StopAutonomous() {
    	addSequential(new ResetGyro(90));
        addParallel(new LogToFile());
    }
}
