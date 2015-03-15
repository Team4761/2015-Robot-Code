package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.commands.elevator.AcceptTote1;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveElevatorToLoad;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveToteBackward;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.ElevatorConveyorBackward;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.LoadTote2;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.LoadTote3;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MainConveyorBackward;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MoveTote1ForwardToClear;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.WatchTote1;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.WatchTote2;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTote extends CommandGroup {
    
    public  AutoTote() {
    	// Remove control of driver and operator
    	addSequential(new AcceptTote1()); // Elevator to Accept Tote 1 (Magnet Sensor 1)
    	addSequential(new MainConveyorBackward()); // Main Conveyor on in
    	addSequential(new ElevatorConveyorBackward()); // Elevator Conveyor on in
    	
    	// Ready LEDs turn on
    	// Human Player drops Tote 1 in
    	// Ready LEDs turn off
    	
    	addSequential(new WatchTote1()); // Stop Main Conveyor when we find and then lose sight of Tote 1 (Break Beam 1)
    	addSequential(new MoveToteBackward()); // Move tote backwards until we lose sight of it (Break Beam 1)
    	
    	// Ready LEDs turn on
    	// Human Player drops Tote 2
    	// Ready LEDs turn off
    	
    	addSequential(new WatchTote2()); // Elevator Conveyor stop when we see Tote 2 (Break Beam 1)
    	addSequential(new MoveElevatorToLoad()); // Elevator goes up to Stack Tote 2 Height (Magnet Sensor 2)
    	addSequential(new MoveTote1ForwardToClear()); // Move Main Conveyor slowly out until we see Tote 1 (Break Beam 1)
    	addSequential(new LoadTote2()); // Move Elevator Conveyor in until we see Tote 2 (Break Beam 2)
    	addSequential(new LoadTote2()); // Move Elevator to Accept Tote Height (Magnet Sensor 1)
    	
    	// Ready LEDs turn on
    	// Human Player drops Tote 3
    	// Ready LEDs turn off
    	
    	addSequential(new LoadTote3()); // Move Elevator Conveyor until we see Tote 3 (Break Beam 0);
    	
    	// Explosion of LEDs
    	// Give control to Driver and Operator
    	// LEDs turn off
    }
}
