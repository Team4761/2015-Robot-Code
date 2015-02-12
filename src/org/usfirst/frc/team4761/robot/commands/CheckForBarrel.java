package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * Just waits until a barrel is found
 */
public class CheckForBarrel extends Command {
	ShortDistanceSensor distanceSensor = RobotMap.barrelSensor;
	double distance;
	double lastDistance;
	public CheckForBarrel() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//TODO: Take care of spikes
		distance = distanceSensor.getDistance();
		if(distance < 25) { //at a barrel
			if(distance - lastDistance < 0) { //sensor at ideal grabbing spot
				return true;
			}
		}
		lastDistance = distance;
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
