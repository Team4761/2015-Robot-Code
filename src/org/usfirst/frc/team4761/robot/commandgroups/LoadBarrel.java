package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.ConveyorPassBarrel;
import org.usfirst.frc.team4761.robot.commands.ConveyorUntilBarrel;
import org.usfirst.frc.team4761.robot.commands.MoveElevatorToBottom;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LoadBarrel extends CommandGroup {
    
    public  LoadBarrel() {
    	addSequential(new ConveyorUntilBarrel());
    	addSequential(new MoveElevatorToBottom());
    	addSequential(new ConveyorPassBarrel());
    }
}
