package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.DistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 * If the distance sensor on the elevator is above the top of a stack of totes,
 * move the elevator down until it is level with the top of the stack.
 */
public class MoveElevatorDownToStackTop extends Command {
	DistanceSensor ds = new DistanceSensor(RobotMap.shortDistanceSensor1);
	
    public MoveElevatorDownToStackTop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(ds.getShortDistance() <= 20) {
    		this.cancel(); //elevator is already below top of stack
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//TODO: lower elevator
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ds.getShortDistance() > 20; //stop running when elevator reached top of stack
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
