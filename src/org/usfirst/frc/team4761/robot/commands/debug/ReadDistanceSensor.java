package org.usfirst.frc.team4761.robot.commands.debug;

import org.usfirst.frc.team4761.robot.sensors.DistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Reads distance and voltage from the distance sensor every 20ms and prints it
 * to the console.
 */
public class ReadDistanceSensor extends Command {
	private final DistanceSensor distanceSensor;
    public ReadDistanceSensor(DistanceSensor distanceSensor) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.distanceSensor = distanceSensor;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("DISTANCE: " + distanceSensor.getDistance() + " | VOLTAGE: " + distanceSensor.getVoltage());
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
