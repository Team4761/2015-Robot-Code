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
	private DistanceSensor distanceSensor1 = RobotMap.testDistanceSensor1;
	private DistanceSensor distanceSensor2 = RobotMap.testDistanceSensor2;
	
    public ReadDistanceSensor() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("distance1,voltage1,distance2,voltage2,diff"); //CSV header
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double diff = Math.abs(distanceSensor1.getDistance() - distanceSensor2.getDistance());
    	System.out.println(distanceSensor1.getDistance() + "," + distanceSensor1.getVoltage() + "," + distanceSensor2.getDistance() + "" + distanceSensor2.getVoltage() + diff);
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
