package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.Wait;
import org.usfirst.frc.team4761.robot.commands.rcarm.CheckMousetrap;
import org.usfirst.frc.team4761.robot.commands.rcarm.RcArmMove;
import org.usfirst.frc.team4761.robot.commands.rcarm.RcArmType;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickUpStepCan extends CommandGroup {
    
    public  PickUpStepCan() {
        // Activate mousetrap
    	addSequential(new CheckMousetrap()); // Wait to see if mousetrap fired
    	addSequential(new Wait(1)); // Wait
    	addSequential(new RcArmMove(RcArmType.EXTEND, 0.5)); // Push pneumatic
    	addSequential(new RcArmMove(255, 0.5)); // Extend star
    	// Drive back
    }
}
