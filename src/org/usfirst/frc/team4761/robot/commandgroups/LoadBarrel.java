package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.conveyorbelts.ConveyorPassBarrel;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.ConveyorUntilBarrel;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveElevatorToBottom;

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
