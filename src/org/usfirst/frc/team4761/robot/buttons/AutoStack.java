package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.commands.StopForever;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.ElevatorConveyorForward;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.GoToElevatorConveyor;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.PushToteOntoStack;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.StopLiftConveyor;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveElevatorToBottom;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveElevatorToStackTop;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStack extends CommandGroup {
    
    public AutoStack (int button, int joystickNum) {
    	addParallel(new StopForever(button, joystickNum)); // Driver cannot move
        //addSequential(new MoveElevatorToBottom());
        addSequential(new MoveElevatorToStackTop());
        
        addSequential(new PushToteOntoStack()); // Find out a better way to know that the tote is on top of the stack
        addSequential(new StopLiftConveyor());
        
        addSequential(new MoveElevatorToBottom());
        addSequential(new GoToElevatorConveyor());
        addSequential(new MoveElevatorToStackTop());
        
        addSequential(new PushToteOntoStack()); // Find out a better way to know that the tote is on top of the stack
        addSequential(new StopLiftConveyor());
    }
}
