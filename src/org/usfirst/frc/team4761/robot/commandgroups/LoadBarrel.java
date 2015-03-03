package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.conveyorbelts.ConveyorPassBarrel;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.ConveyorUntilBarrel;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveElevatorToBottom;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Load up a barrel onto the elevator from the conveyor belt.
 */
public class LoadBarrel extends CommandGroup {
    
    public  LoadBarrel() {
    	addSequential(new ConveyorUntilBarrel());
    	addSequential(new MoveElevatorToBottom());
    	addSequential(new ConveyorPassBarrel());
    }
}
