package org.usfirst.frc.team4761.robot.buttons;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorBarrelFixToggle extends Command {
	
	Boolean direction; // What direction to go in, True for upwards, False for downwards.
	
	Boolean	rOne, rTwo; // This will help with termination.
    public ElevatorBarrelFixToggle() {
    	requires(Robot.elevator);
    	
    	rOne = true;
    	rTwo = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (rOne){
    		if (direction){
    			Robot.elevator.raise();
    		} else if (!direction){
    			Robot.elevator.lower();
    		}
    		
    		
    		if (Robot.robotMap.elevatorMagnetDetectorDown.get()){
    			rOne = false;
    			direction = false; // We now want to go downwards.
    			Robot.elevator.stop();
    		}
    		
    		if (!Robot.robotMap.elevatorDI.get()){ // Apparently this must be inverted.
    			direction = true; // It hit the bottom it should go upwards.
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (rTwo){
    		if (direction)
    			Robot.elevator.raise();
    		else
    			Robot.elevator.lower();
    		
    		if (Robot.robotMap.elevatorDI.get()){
    			direction = true; // Wrong way!
    		}
    		
    		if (Robot.robotMap.elevatorMagnetDetectorUp.get()){
    			rTwo = false;
    			direction = false; // We should probably go down now.
    			Robot.elevator.stop();
    		}
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
