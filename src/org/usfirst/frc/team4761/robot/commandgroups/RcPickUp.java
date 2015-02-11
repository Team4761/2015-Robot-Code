package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.CheckForBarrel;
import org.usfirst.frc.team4761.robot.commands.DriveAlongStep;
import org.usfirst.frc.team4761.robot.commands.RcLift;
import org.usfirst.frc.team4761.robot.commands.RcLower;
import org.usfirst.frc.team4761.robot.commands.RcSpinIn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RcPickUp extends CommandGroup {
    
    public  RcPickUp (boolean forward) {
    	addSequential(new RcLift());
    	addSequential(new RcSpinIn());
    	addSequential(new RcLower());
    }
}
