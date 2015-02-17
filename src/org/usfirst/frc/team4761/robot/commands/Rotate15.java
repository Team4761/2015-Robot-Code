package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Rotate15 extends Command {

    public Rotate15() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveAbsolute(0, 0, 45);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (isTimedOut()) {
    		System.out.println("Rotate Away");
    		System.out.println(Robot.driveTrain.gyroPidController.getSetpoint());
    		System.out.println(GyroSensor.getDegrees());
    	}
    	
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}