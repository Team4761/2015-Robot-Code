package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorBarrelFixToggle extends Command {
	
	Boolean direction; // What direction to go in, True for upwards, False for downwards.
	
	Boolean	ROne, RTwo; // This will help with termination.
    public ElevatorBarrelFixToggle() {
    	requires(Robot.elevator);
    	
    	ROne = true;
    	RTwo = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (ROne){
    		if (direction)
    			Robot.elevator.raise();
    		else if (!direction)
    			Robot.elevator.lower();
    		
    		
    		if (RobotMap.elevatorMagnetDetectorDown.get())
    			ROne = false;
    			direction = false; // We now want to go downwards.
    		
    		if (!RobotMap.elevatorDI.get()) // Apparently this must be inverted.
    			direction = true; // It hit the bottom it should go upwards.
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (RTwo){
    		if (direction)
    			Robot.elevator.raise();
    		else
    			Robot.elevator.lower();
    		
    		if (RobotMap.elevatorMagnetDetectorDown.get())
    			direction = true; // Wrong way!
    		
    		if (RobotMap.elevatorMagnetDetectorUp.get())
    			RTwo = false;
    			direction = false; // We should probably go down now.
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
