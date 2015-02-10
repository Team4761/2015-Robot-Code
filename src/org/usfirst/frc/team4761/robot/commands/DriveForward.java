package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.DistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Move the robot forward, using mecanum wheels.
 */
public class DriveForward extends Command {
	private double deltaTime = 0;
	private long begin = 0, end = 0;
	
	DistanceSensor distanceSensor = new DistanceSensor(RobotMap.mediumDistanceSensor1);

    public DriveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	begin = System.currentTimeMillis() % 1000;
		
    	Robot.driveTrain.drive(0.15, 0.15, 0, deltaTime);

		deltaTime = (begin - end) / 1000.0;
		end = System.currentTimeMillis() % 1000;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return distanceSensor.getLongDistance() < 25;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
