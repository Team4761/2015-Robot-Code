package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.commands.LEDGreen;
import org.usfirst.frc.team4761.robot.commands.LEDRed;
import org.usfirst.frc.team4761.robot.commands.LEDWipe;
import org.usfirst.frc.team4761.robot.commands.StopForever;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.ElevatorConveyorBackwardSlow;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.LoadTote2;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.LoadTote3;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MainConveyorBackward;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MoveTote1ForwardToClear;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MoveToteBackward;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.MoveToteToEndOfElevator;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.WatchTote1;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.WatchTote2;
import org.usfirst.frc.team4761.robot.commands.elevator.AcceptTote1;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveElevatorToLoad;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTote extends CommandGroup {
    
    public  AutoTote (int button, int joystickNum) {
    	addParallel(new StopForever(button, joystickNum)); // Driver cannot move (THIS NEEDS TESTING!!!)
    	addSequential(new AcceptTote1()); // Elevator to Accept Tote 1 (Magnet Sensor 1)
    	addSequential(new MainConveyorBackward()); // Main Conveyor on in
    	addSequential(new ElevatorConveyorBackwardSlow()); // Elevator Conveyor on in
    	
    	addParallel(new LEDGreen()); // Ready LEDs turn on
    	// Human Player drops Tote 1 in
    	addSequential(new MoveToteToEndOfElevator()); // Move tote to end of Elevator
    	addParallel(new LEDRed()); // Ready LEDs turn off
    	
    	addSequential(new WatchTote1()); // Stop Main Conveyor when we find and then lose sight of Tote 1 (Break Beam 1)
    	addSequential(new MoveToteBackward()); // Move tote backwards until we lose sight of it (Break Beam 1)
    	
    	addParallel(new LEDGreen()); // Ready LEDs turn on
    	// Human Player drops Tote 2
    	addSequential(new MoveToteToEndOfElevator()); // Move tote to end of Elevator
    	addParallel(new LEDRed()); // Ready LEDs turn off
    	
    	addSequential(new WatchTote2()); // Elevator Conveyor stop when we see Tote 2 (Break Beam 1)
    	addSequential(new MoveElevatorToLoad()); // Elevator goes up to Stack Tote 2 Height (Magnet Sensor 2)
    	addSequential(new MoveTote1ForwardToClear()); // Move Main Conveyor slowly out until we see Tote 1 (Break Beam 1)
    	addSequential(new LoadTote2()); // Move Elevator Conveyor in until we see Tote 2 (Break Beam 2)
    	addSequential(new LoadTote2()); // Move Elevator to Accept Tote Height (Magnet Sensor 1)
    	
    	addParallel(new LEDGreen()); // Ready LEDs turn on
    	// Human Player drops Tote 3
    	addSequential(new MoveToteToEndOfElevator()); // Move tote to end of Elevator
    	addParallel(new LEDRed()); // Ready LEDs turn on
    	
    	addSequential(new LoadTote3()); // Move Elevator Conveyor until we see Tote 3 (Break Beam 0);
    	
    	// Explosion of LEDs for 3 seconds
    	addParallel(new LEDWipe()); // LEDs turn off
    }
}
