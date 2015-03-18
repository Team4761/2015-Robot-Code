package org.usfirst.frc.team4761.robot.commands.debug;

import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.DistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Reads distance and voltage from the distance sensor every 20ms and prints it
 * to the console.
 */
public class ReadDistanceSensor extends Command {
	private DistanceSensor distanceSensor1 = RobotMap.barrelDistanceSensor;
	private DistanceSensor distanceSensor2 = RobotMap.outerConveyorToteDistanceSensor;
	private String name1, name2;
	
    public ReadDistanceSensor(String name1, String name2) {
    	this.name1 = name1;
    	this.name2 = name2;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println((double) (Math.abs(distanceSensor1.getDistance() - distanceSensor2.getDistance())));
    	System.out.println("NAME: " + name1 + "DISTANCE: " + distanceSensor1.getDistance() + " | VOLTAGE: " + distanceSensor1.getVoltage());
    	System.out.println("NAME: " + name2 + "DISTANCE: " + distanceSensor2.getDistance() + " | VOLTAGE: " + distanceSensor2.getVoltage());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
