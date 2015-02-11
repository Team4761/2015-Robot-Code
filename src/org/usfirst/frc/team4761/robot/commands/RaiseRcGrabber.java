package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class RaiseRcGrabber extends Command {
	
	DoubleSolenoid solenoid = Robot.rcGrabber.solenoid; 
	
	public RaiseRcGrabber(){
		requires(Robot.rcGrabber);
	}
	
    protected void initialize() {
    	setTimeout(1);
    }

    protected void execute() {
    	Robot.rcGrabber.set(DoubleSolenoid.Value.kReverse);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {}

	protected void interrupted() {}
}
