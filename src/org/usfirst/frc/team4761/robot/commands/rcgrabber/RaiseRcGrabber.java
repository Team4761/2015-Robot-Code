package org.usfirst.frc.team4761.robot.commands.rcgrabber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

/**
 * A command to raise the RcGrabber using the pneumatics in the {@link org.usfirst.frc.team4761.robot.subsystem.RcGrabber RcGrabber subsystem}.
 * @author mathias
 */

public class RaiseRcGrabber extends Command {
	
	DoubleSolenoid solenoid = Robot.rcGrabber.solenoid;
	
	public RaiseRcGrabber() {
		requires(Robot.rcGrabber);
	}
	
	protected void initialize() {
		setTimeout(1.2);
		Robot.rcGrabber.set(DoubleSolenoid.Value.kReverse);
	}
	
	protected void execute() {
	}
	
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}
}
