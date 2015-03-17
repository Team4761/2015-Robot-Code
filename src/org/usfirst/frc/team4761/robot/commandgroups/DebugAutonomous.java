package org.usfirst.frc.team4761.robot.commandgroups;

import org.usfirst.frc.team4761.robot.commands.debug.ReadDistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous for debugging stuff. Feel free to delete whatever is currently in
 * here. If you put something in here, do not expect it to stay.
 */
public class DebugAutonomous extends CommandGroup {
    public  DebugAutonomous() {
    	//TODO: replace with real port
    	addSequential(new ReadDistanceSensor(new MediumDistanceSensor(new AnalogInput(0))));
    }
}
