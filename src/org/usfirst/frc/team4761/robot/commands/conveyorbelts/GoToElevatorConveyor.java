package org.usfirst.frc.team4761.robot.commands.conveyorbelts;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToElevatorConveyor extends Command {
	private boolean passedBeam = false;

    public GoToElevatorConveyor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.mainConveyorBelt);
    	requires(Robot.liftConveyorBelt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	passedBeam = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!RobotMap.breakBeamElevatorBegin.get() && !passedBeam) {
    		passedBeam = true;
    	}
    	
    	Robot.mainConveyorBelt.forward();
    	Robot.liftConveyorBelt.go(0.8);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.breakBeamElevatorBegin.get() && passedBeam;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mainConveyorBelt.stop();
    	Robot.liftConveyorBelt.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
