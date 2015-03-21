package org.usfirst.frc.team4761.robot.commands.conveyorbelts;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadTote2 extends Command {

    public LoadTote2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.liftConveyorBelt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	passedBeam = false;
    	setTimeout(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*if (!RobotMap.breakBeamBegin.get() && !passedBeam) {
    		passedBeam = true;
    	} else {*/
    		Robot.liftConveyorBelt.backward();
    	//}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return RobotMap.breakBeamBegin.get() && isTimedOut();
        //return RobotMap.breakBeamBegin.get() && passedBeam;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
