package org.usfirst.frc.team4761.robot.commands.drivetrain;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToTotes extends Command {
	MediumDistanceSensor sensor = Robot.robotMap.outerConveyorToteDistanceSensor;

    public DriveToTotes() {
        requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.driveAbsolute(0, .5, 0);
    }

    protected boolean isFinished() {
        return Robot.robotMap.outerConveyorToteDistanceSensor.getDistance() <= 30;
    }

    protected void end() {
    	Robot.driveTrain.driveAbsolute(0, 0, 0);
    }

    protected void interrupted() {
    }
}
