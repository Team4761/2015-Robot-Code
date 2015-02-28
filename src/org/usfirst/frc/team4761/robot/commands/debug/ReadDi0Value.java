package org.usfirst.frc.team4761.robot.commands.debug;

import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that simply reads and logs the value of the digital input on port 0
 */
public class ReadDi0Value extends Command {

	private DigitalInput di = Robot.robotMap.someDI;
	private Logger log = new Logger("Digital Input 0 Value");
    public ReadDi0Value() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(!di.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
