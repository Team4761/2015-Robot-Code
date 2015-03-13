package org.usfirst.frc.team4761.robot.buttons;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTote extends CommandGroup {
    
    public  AutoTote() {
    	// Elevator to Accept Tote 1 (Magnet Sensor 1)
    	// Elevator Conveyor on in
    	// Main Conveyor on in
    	// Ready LEDs turn on
    	// Human Player drops Tote 1 in
    	// Ready LEDs turn off
    	// Stop Main Conveyor when we find and then lose sight of Tote 1 (Break Beam 1)
    	// Ready LEDs turn on
    	// Human Player drops Tote 2
    	// Ready LEDs turn off
    	// Elevator Conveyor stop when we see Tote 2 (Break Beam 1)
    	// Elevator goes up to Stack Tote 2 Height (Magnet Sensor 2)
    	// Move Main Conveyor slowly out until we see Tote 1 (Break Beam 1)
    	// Move Elevator Conveyor in until we see Tote 2 (Break Beam 2)
    	// Move Elevator to Accept Tote Height (Magnet Sensor 1)
    	// Ready LEDs turn on
    	// Human Player drops Tote 3
    	// Ready LEDs turn off
    	// Move Elevator Conveyor until we see Tote 3 (Break Beam 0);
    	// Explosion of LEDs
    	// Give control to Driver and Operator
    	// LEDs turn off
    }
}
