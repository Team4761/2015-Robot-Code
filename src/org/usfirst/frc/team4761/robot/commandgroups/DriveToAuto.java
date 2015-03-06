package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.drivetrain.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drive to the auto zone and reset the gyro in the process. Drive for 5 seconds then stop.
 */
public class DriveToAuto extends CommandGroup {
    
    public  DriveToAuto() {
    	addSequential(new Drive(0.5, 0, 0, 3, "ABSOLUTE"));
    }
}
