package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToElevatorConveyor extends Command {
	private ShortDistanceSensor sensor = Robot.robotMap.outerConveyorBarrelDistanceSensor;
	int passes = 0;

    public GoToElevatorConveyor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.mainConveyorBelt);
    	requires(Robot.liftConveyorBelt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	passes = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (sensor.getDistance() < 20 && passes == 0) {
    		passes++;
    	}
    	
    	Robot.mainConveyorBelt.go(1);
    	Robot.liftConveyorBelt.go(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return sensor.getDistance() > 45 && passes == 1;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mainConveyorBelt.go(0);
    	Robot.liftConveyorBelt.go(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
