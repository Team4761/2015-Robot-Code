package org.usfirst.frc.team4761.robot.commands.drivetrain;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToTotes extends Command {
	MediumDistanceSensor sensor = RobotMap.outerConveyorToteDistanceSensor;

    public DriveToTotes() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveAbsolute(0, 0.5, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return RobotMap.outerConveyorToteDistanceSensor.getDistance() <= 30;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.driveAbsolute(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
