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
	MediumDistanceSensor port2 = new MediumDistanceSensor(new AnalogInput(2));
	MediumDistanceSensor port3 = new MediumDistanceSensor(new AnalogInput(3));
    public  DebugAutonomous() {
    	addParallel(new ReadDistanceSensor(port2, "port2"));
    	addParallel(new ReadDistanceSensor(port3, "port3"));
    }
}
