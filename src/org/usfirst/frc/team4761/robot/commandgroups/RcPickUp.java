package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.DriveForward;
import org.usfirst.frc.team4761.robot.commands.RcLift;
import org.usfirst.frc.team4761.robot.commands.RcLower;
import org.usfirst.frc.team4761.robot.commands.RcSpinIn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RcPickUp extends CommandGroup {
    
    public  RcPickUp() {
    	addSequential(new DriveForward());
    	// Need to add other drive commands
    	addSequential(new RcLift());
    	addSequential(new RcSpinIn());
    	addSequential(new RcLower());
    }
}
