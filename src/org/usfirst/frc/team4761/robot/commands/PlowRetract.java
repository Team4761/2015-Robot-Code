package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.Robot;

/**
 * Retract using pneumatics of the {@link org.usfirst.frc.team4761.robot.subsystems.Plow plow}.
 * @author mathias
 */

public class PlowRetract extends Command {
	
	public PlowRetract() {
		requires(Robot.plower);
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		Robot.plower.set(DoubleSolenoid.Value.kReverse);
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}
}
