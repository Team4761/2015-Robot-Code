package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.commands.conveyorbelts.GoToElevatorConveyor;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MoveElevatorConveyorForward;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveElevatorToBottom;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveElevatorToStackTop;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStack extends CommandGroup {
    
    public  AutoStack() {
        addSequential(new MoveElevatorToBottom());
        addSequential(new MoveElevatorToStackTop());
        
        addSequential(new MoveElevatorConveyorForward()); // Find out a better way to know that the tote is on top of the stack
        
        addSequential(new MoveElevatorToBottom());
        addSequential(new GoToElevatorConveyor());
        addSequential(new MoveElevatorToStackTop());
        
        addSequential(new MoveElevatorConveyorForward()); // Find out a better way to know that the tote is on top of the stack
    }
}
