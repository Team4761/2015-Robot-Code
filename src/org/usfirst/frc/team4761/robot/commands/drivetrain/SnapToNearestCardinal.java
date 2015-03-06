package org.usfirst.frc.team4761.robot.commands.drivetrain;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the set-point of the PID to rotate the robot to the nearest cardinal direction.
 */
public class SnapToNearestCardinal extends Command{
    public SnapToNearestCardinal () {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	double orientation = Robot.driveTrain.gyroPidController.getSetpoint();
    	long turnTo = Math.round(orientation/90);
    	Robot.driveTrain.gyroPidController.setSetpoint(turnTo);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
