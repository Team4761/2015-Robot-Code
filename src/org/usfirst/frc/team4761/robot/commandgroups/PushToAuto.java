package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commands.drivetrain.Drive;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberMove;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberType;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * An autonomous in which the robot drives to the auto zone and picks up a barrel on the way.
 */
public class PushToAuto extends CommandGroup {
    
    public  PushToAuto (int angle) {
    	addSequential(new ResetGyro(angle));
    	addSequential(new RcGrabberMove(RcGrabberType.OUT));
    	addSequential(new RcGrabberMove(RcGrabberType.UP, 1.2));
    	addSequential(new RcGrabberMove(RcGrabberType.IN));
    	addSequential(new Drive(-0.1, -0.5, 0, 6, "ABSOLUTE"));
    }
}